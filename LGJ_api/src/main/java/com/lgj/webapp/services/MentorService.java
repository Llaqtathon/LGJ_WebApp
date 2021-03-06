package com.lgj.webapp.services;

import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.lgj.webapp.CompositeKeys.MentorEditionKey;
import com.lgj.webapp.dto.MentorAreaRequest;
import com.lgj.webapp.dto.MentorAvailabilitiesRequest;
import com.lgj.webapp.dto.MentorEditionRequest;
import com.lgj.webapp.dto.MentorRequest;
import com.lgj.webapp.entities.Edition;
import com.lgj.webapp.entities.Mentor;
import com.lgj.webapp.entities.MentorArea;
import com.lgj.webapp.entities.MentorAvailability;
import com.lgj.webapp.entities.MentorEdition;
// import com.lgj.webapp.entities.User;
import com.lgj.webapp.repository.AreaRespository;
import com.lgj.webapp.repository.EditionRepository;
import com.lgj.webapp.repository.MentorAreaRepository;
import com.lgj.webapp.repository.MentorAvailabilityRepository;
import com.lgj.webapp.repository.MentorEditionRepository;
import com.lgj.webapp.repository.MentorRepository;
// import com.lgj.webapp.repository.UserRepository;
import com.lgj.webapp.util.RolSelection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MentorService {
  
  // private UserRepository userRepository;
  private EditionRepository editionRepository;
  private AreaRespository areaRespository;
  private MentorRepository mentorRepository;
  private MentorAreaRepository mentorAreaRepository;
  private MentorAvailabilityRepository mentorAvailabilityRepository;
  private MentorEditionRepository mentorEditionRepository;

  public MentorService(
    MentorRepository mentorRepository,
    EditionRepository editionRepository,
    // UserRepository userRepository,
    MentorAreaRepository mentorAreaRepository,
    MentorAvailabilityRepository mentorAvailabilityRepository,
    MentorEditionRepository mentorEditionRepository,
    AreaRespository areaRespository
  ) {
    this.mentorRepository = mentorRepository;
    this.editionRepository = editionRepository;
    this.mentorAreaRepository = mentorAreaRepository;
    this.mentorAvailabilityRepository = mentorAvailabilityRepository;
    this.mentorEditionRepository = mentorEditionRepository;
    // this.userRepository = userRepository;
    this.areaRespository = areaRespository;
  }
  
  @Transactional(readOnly = true)
  public List<Mentor> getAll() {
    return mentorRepository.findAll();
  }
  @Transactional(readOnly = true)
  public Mentor getMentorById(Long mentorId) {
    return mentorRepository.getOne(mentorId);
  }

  @Transactional(readOnly = true)
  public List<Mentor> findByEditionId(Long editionId) {
    return mentorEditionRepository.findMentorByEditionId(editionId);
  }
  @Transactional(readOnly = true)
  public List<MentorEdition> findMentorEditionByEditionId(Long editionId) {
    return mentorEditionRepository.findByEditionId(editionId);
  }

  @Transactional(readOnly = true)
  public List<Mentor> findByPartOfFullName(String text) {
    List<Mentor> mentors = mentorRepository.findByNamesOrLastNames(text);
    return mentors;
  }

  // Busco en los usuarios,
  // si existe el id seleccionado en mentor, entonces solo lo selecciona
  // sino, lo vuelve mentor
  @Transactional
  private Integer mentorFromUserId(Long userId) {
    return mentorRepository.saveOnlyMentor("",userId);
  }
  @Transactional
  public Mentor setMentorFromUser(Long userId) {
    Integer mentorId = mentorFromUserId(userId);
    if (mentorId == 0) {
      return null;
    }
    Mentor mentor = mentorRepository.getOne(userId);
    //mentor.setRol(RolSelection.MENTOR);
    return mentor;
  }

  
  @Transactional
  //crear mentor que no era participante:
  public Mentor createMentor(Mentor mentor) throws ParseException {
    //nombres, apellidos, url_photo, areas
    //si vacio poner valores por defecto
    String defaultUsername = mentor.getNombres().substring(4) + "." + mentor.getApellidos().substring(4);
    //mentor.setRol(RolSelection.MENTOR);
    mentor.setDni("88888888");
    if (mentor.getTelefono() == null) {
      mentor.setTelefono("99999999");
    }
    if (mentor.getNacimiento() == null) {
      mentor.setNacimiento(LocalDate.parse("1990-01-01") );
    }
    if (mentor.getEmail() == null) {
      mentor.setEmail(defaultUsername + "@confirmar.com");
    }
    if (mentor.getUsername() == null) {
      mentor.setUsername(defaultUsername);
    }
    if (mentor.getPassword() == null) {
      mentor.setPassword("actualizarLGJ");
    }
    return mentorRepository.save(mentor);
  }

  @Transactional
  public Mentor updateMentor(Long mentorId, MentorRequest mentor) {
    Mentor mentorToUpdate = mentorRepository.getOne(mentorId);
    if (mentor.getNombres() != null) {
      mentorToUpdate.setNombres(mentor.getNombres());
    }
    if (mentor.getApellidos() != null) {
      mentorToUpdate.setApellidos(mentor.getApellidos());
    }
    if (mentor.getPhone() != null) {
      mentorToUpdate.setTelefono(mentor.getPhone());
    }
    if (mentor.getEmail() != null) {
      mentorToUpdate.setEmail(mentor.getEmail());
    }
    if (mentor.getBirthdate() != null) {
      mentorToUpdate.setNacimiento(mentor.getBirthdate());
    }
    if (mentor.getUrlPhoto() != null) {
      mentorToUpdate.setUrlPhoto(mentor.getUrlPhoto());
    }
    if (mentor.getAreas() != null) {
      mentorToUpdate.setAreas(mentor.getAreas());
    }
    return mentorRepository.save(mentorToUpdate);
  }

  @Transactional
  public List<MentorArea> createMentorAreas(Long mentorId, MentorAreaRequest mentorArea) {
    Mentor mentor = mentorRepository.getOne(mentorId);
    List<MentorArea> mentorAreas = mentorArea.getAreas()
      .stream()
      .map(area ->
        MentorArea.builder()
        .area(areaRespository.getOne(area.getAreaId()))
        .mentor(mentor)
        .yearsOfExperience(area.getYearsOfExperience())
        .priority(area.getPriority())
        .build()
      )
      .collect(Collectors.toList());
    
    return mentorAreaRepository.saveAll(mentorAreas);
  }
  @Transactional
  public List<MentorArea> updateMentorAreas(Long mentorId, MentorAreaRequest mentorArea) {
    List<MentorArea> mentorAreas = mentorArea.getAreas()
      .stream()
      .map(area ->
        {
          MentorArea marea = mentorAreaRepository.getOneByMentorIdAndAreaId(mentorId, area.getAreaId());
          if (marea != null) {
            marea.setYearsOfExperience(area.getYearsOfExperience());
            marea.setPriority(area.getPriority());
          }
          return marea;
        }
      )
      .collect(Collectors.toList());
    
    return mentorAreaRepository.saveAll(mentorAreas);
  }
  
  @Transactional
  public void deleteMentorAreas(Long mentorId, List<Long> areasId) {
    Mentor mentor = mentorRepository.getById(mentorId);
    List<MentorArea> toRemove = mentorAreaRepository.findByMentor(mentor);
    mentorAreaRepository.deleteAll(toRemove);
  }

  //disponibilidad
  @Transactional(readOnly = true)
  public List<MentorAvailability> getMentorAvailabilities(Long mentorId, Long editionId) {
    return mentorAvailabilityRepository.findAvailabilityByMentorIdAndEditionId(mentorId, editionId);
  }
  @Transactional
  public List<MentorAvailability> saveMentorAvailability(
    MentorAvailabilitiesRequest maRequest) {
    MentorEdition mentorEdition = mentorEditionRepository
        .getOneByMentorIdAndEditionId(maRequest.getMentorId(), maRequest.getEditionId());
    List<MentorAvailability> mentorAvailabilities = maRequest.getAvailabilities()
      .stream()
      .map(availability ->
        MentorAvailability.builder()
        .mentorEdition(mentorEdition)
        .dateStart(availability.getDateStart())
        .dateEnd(availability.getDateEnd())
        .build()
      )
      .collect(Collectors.toList());

    return mentorAvailabilityRepository.saveAll(mentorAvailabilities);
  }
  @Transactional
  public void deleteMentorAvailability(Long mentorAvailabilityId) {
    mentorAvailabilityRepository.deleteById(mentorAvailabilityId);
  }
  @Transactional
  public void deleteMentorAvailabilities(List<Long> mentorAvailabilitiesId) {
    mentorAvailabilityRepository.deleteAllById(mentorAvailabilitiesId);
  }
  
  
  @Transactional(readOnly = true)
  public MentorEdition findByIdAndEditionId(Long mentorId, Long editionId) {
    return mentorEditionRepository.getOneByMentorIdAndEditionId(mentorId, editionId);
  }

  @Transactional
  public MentorEdition createMentorEdition(Long editionId, MentorEditionRequest request) {
    Mentor mentor = mentorRepository.getOne(request.getMentorId());
    Edition edition = editionRepository.getOne(editionId);
    MentorEditionKey mentorEditionKey = new MentorEditionKey(request.getMentorId(), editionId);
    MentorEdition mentorEdition = MentorEdition.builder()
      .id(mentorEditionKey)
      .mentor(mentor)
      .edition(edition)
      .status(request.getStatus())
      .build();
    return mentorEditionRepository.save(mentorEdition);
  }
  @Transactional
  public MentorEdition updateMentorEdition(Long editionId, MentorEditionRequest request) {
    MentorEdition mentorEdition =  mentorEditionRepository.getOneByMentorIdAndEditionId(
      request.getMentorId(), editionId);
    mentorEdition.setStatus(request.getStatus());
    return mentorEditionRepository.save(mentorEdition);
  }
  @Transactional
  public void deleteMentorEdition(Long editionId, Long mentorId) {
    MentorEdition toRemove = mentorEditionRepository.getOneByMentorIdAndEditionId(mentorId,editionId);
    deleteMentorAvailabilities(
      toRemove.getAvailabilities().stream().map(
        (MentorAvailability ma) -> ma.getId()
        ).collect(Collectors.toList()
      )
    );
    mentorEditionRepository.delete(toRemove);
  }


}

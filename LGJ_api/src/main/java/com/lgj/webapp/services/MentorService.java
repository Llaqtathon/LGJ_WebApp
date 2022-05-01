package com.lgj.webapp.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import com.lgj.webapp.dto.MentorAreaRequest;
import com.lgj.webapp.dto.MentorAvailabilitiesRequest;
import com.lgj.webapp.entities.Mentor;
import com.lgj.webapp.entities.MentorArea;
import com.lgj.webapp.entities.MentorAvailability;
import com.lgj.webapp.entities.MentorEdition;
import com.lgj.webapp.entities.User;
import com.lgj.webapp.repository.AreaRespository;
import com.lgj.webapp.repository.EditionRepository;
import com.lgj.webapp.repository.MentorAreaRepository;
import com.lgj.webapp.repository.MentorAvailabilityRepository;
import com.lgj.webapp.repository.MentorEditionRepository;
import com.lgj.webapp.repository.MentorRepository;
import com.lgj.webapp.repository.UserRepository;
import com.lgj.webapp.util.GeneralStatus;
import com.lgj.webapp.util.RolSelection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MentorService {
  
  private UserRepository userRepository;
  private EditionRepository editionRepository;
  private AreaRespository areaRespository;
  private MentorRepository mentorRepository;
  private MentorAreaRepository mentorAreaRepository;
  private MentorAvailabilityRepository mentorAvailabilityRepository;
  private MentorEditionRepository mentorEditionRepository;

  public MentorService(
    MentorRepository mentorRepository,
    EditionRepository editionRepository,
    UserRepository userRepository,
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
    this.userRepository = userRepository;
    this.areaRespository = areaRespository;
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
  public List<Mentor> findByPartOfFullName(String text) {
    List<Mentor> mentors = mentorRepository.findByNamesOrLastNames(text);
    return mentors;
  }

  // Busco en los usuarios,
  // si existe el id seleccionado en mentor, entonces solo lo selecciona
  // sino, lo vuelve mentor
  @Transactional
  public Mentor mentorFromUserId(Long userId) {
    Mentor mentor = mentorRepository.getOne(userId);
    if (mentor == null) {
      User user = userRepository.getOne(userId);
      // User user = userRepository.findById(userId);
      mentor = Mentor.toBuilder(user).build();
    }
    return mentorRepository.save(mentor);
  }
  
  @Transactional
  //crear mentor que no era participante:
  public Mentor createMentor(Mentor mentor) throws ParseException {
    //nombres, apellidos, url_photo, areas
    //si vacio poner valores por defecto
    String defaultUsername = mentor.getNombres().substring(4) + "." + mentor.getApellidos().substring(4);
    mentor.setRol(RolSelection.Mentor);
    mentor.setDni("88888888");
    if (mentor.getTelefono() == null) {
      mentor.setTelefono("99999999");
    }
    if (mentor.getNacimiento() == null) {
      mentor.setNacimiento(new SimpleDateFormat("yyyy/MM/dd").parse("1990/01/01") );
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
  public Mentor updateMentor(Long mentorId, Mentor mentor) {
    mentor.setId(mentorId);
    return mentorRepository.save(mentor);
  }

  @Transactional
  public List<MentorArea> saveMentorAreas(Long mentorId, MentorAreaRequest mentorArea) {
    Mentor mentor = mentorRepository.getOne(mentorId);
    List<MentorArea> mentorAreas = mentorArea.getAreas()
      .stream()
      .map(area ->
        MentorArea.builder()
        .area(areaRespository.getOne(area.getAreaId()))
        .mentor(mentor)
        .yearsOfExperience(area.getYearsOfExperience())
        .priority(area.getYearsOfExperience())
        .build()
      )
      .collect(Collectors.toList());

    return mentorAreaRepository.saveAll(mentorAreas);
  }

  //disponibilidad
  @Transactional(readOnly = true)
  public List<MentorAvailability> getMentorAvailabilities(Long mentorId, Long editionId) {
    return mentorAvailabilityRepository.findAvailabilityByMentorIdAndEditionId(mentorId, editionId);
  }

  @Transactional
  public List<MentorAvailability> saveMentorAvailability(
    Long editionId, Long mentorId,
    MentorAvailabilitiesRequest maRequest) {
    MentorEdition mentorEdition = (MentorEdition) mentorEditionRepository
        .getOneByMentorIdAndEditionId(mentorId, editionId);
    List<MentorAvailability> mentorAvailabilities = maRequest.getAvailabilities()
      .stream()
      .map(availability ->
        MentorAvailability.builder()
        .id(availability.getMentorAvailabilityId())
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
  public void saveMentorEdition(Long mentorId, Long editionId) {
    Mentor mentor = mentorRepository.getOne(mentorId);
    MentorEdition mentorEdition = MentorEdition.builder()
      .mentor(mentor)
      .edition(editionRepository.getOne(editionId))
      .status(GeneralStatus.EN_CONSULTA)
      .build();
    mentorEditionRepository.save(mentorEdition);
  }
  
  @Transactional
  public MentorEdition updateStatus(
    Long mentorId, Long editionId, GeneralStatus status) {
    MentorEdition mentorEdition = mentorEditionRepository
          .getOneByMentorIdAndEditionId(mentorId, editionId);
    mentorEdition.setStatus(status);
    return mentorEditionRepository.save(mentorEdition);
  }



}

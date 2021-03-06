package com.lgj.webapp.services;


import java.util.List;


// import java.time.Duration;
// import java.util.List;

// import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.lgj.webapp.CompositeKeys.UserMicroKey;
import com.lgj.webapp.dto.MicroEventoAsigRequest;
import com.lgj.webapp.dto.MicroevntRequest;
import com.lgj.webapp.entities.Edition;
// import com.lgj.webapp.dto.MicroEventoOrgResponse;

import com.lgj.webapp.entities.MicroEvento;
import com.lgj.webapp.entities.UserMicroE;
import com.lgj.webapp.repository.EditionRepository;
import com.lgj.webapp.repository.MicroeventoRepository;

import com.lgj.webapp.util.GeneralStatus;

import com.lgj.webapp.repository.MicroeventoUserRespository;
import com.lgj.webapp.repository.UserRepository;
// import com.lgj.webapp.util.GeneralStatus;
// import com.lgj.webapp.util.TipoMicroEvento;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MicroeventoService {
    private MicroeventoRepository microRepository;
    private MicroeventoUserRespository microUserRepository;
    private UserRepository userRepository;
    private EditionRepository editionRepository;

    public MicroeventoService(
        MicroeventoRepository repository, 
        UserRepository userRepository,
        EditionRepository editionRepository,
        MicroeventoUserRespository microUserRepository) {
        this.microRepository = repository;
        this.userRepository = userRepository;
        this.microUserRepository = microUserRepository;
        this.editionRepository = editionRepository;
    }

    @Transactional
    public MicroEvento createmicroevento(MicroevntRequest micro) {
        Edition edition = editionRepository.getOne(micro.getEditionId());
        MicroEvento m = MicroEvento.builder()
            .name(micro.getName())
            .description(micro.getDescription())
            .nombrePonente(micro.getNombrePonente())
            .inicio(micro.getInicio())
            .fin(micro.getFin())
            .cupo(micro.getCupo())
            .tipo(micro.getTipo())
            .status(micro.getStatus())
            .edition(edition)
            .build();
        return microRepository.save(m);
    }
    @Transactional
    public MicroEvento updatemicroevento(Long microEvntId, MicroevntRequest micro) {
        MicroEvento m = microRepository.getOne(microEvntId);
        m.setName(micro.getName());
        m.setDescription(micro.getDescription());
        m.setNombrePonente(micro.getNombrePonente());
        m.setInicio(micro.getInicio());
        m.setFin(micro.getFin());
        m.setCupo(micro.getCupo());
        m.setTipo(micro.getTipo());
        m.setStatus(micro.getStatus());
        return microRepository.save(m);
    }
    @Transactional(readOnly = true)
    public List<UserMicroE> getmicroeventoByUserId(Long userId) {
        return microUserRepository.findByUserId(userId);
    }
    @Transactional(readOnly = true)
    public List<UserMicroE> getmicroeventoByMicroeventoId(Long microId) {
        return microUserRepository.findByMicroeventoId(microId);
    }
    @Transactional(readOnly = true)
    public List<MicroEvento> getmicroeventoByEditionId(Long editionId) {
        return microRepository.findByEditionId(editionId);
    }
    @Transactional(readOnly = true)
    public MicroEvento getmicroeventoById(Long id) {
        return microRepository.findById(id).get();
    }
    @Transactional(readOnly = true)
    public List<MicroEvento> getAllmicroeventos() {
        return microRepository.findAll();
    }
    // @Transactional 
    // public MicroEvento createFull(MicroEventoOrgRequest micro) {
    //     MicroEvento microevento = MicroEvento.builder()
    //         .tipo(micro.getTipo())
    //         .status( (micro.getStatus() == null) ? GeneralStatus.EN_CONSULTA : micro.getStatus() )
    //         .inicio(micro.getInicio())
    //         .fin( (micro.getFin()== null) ?
    //                 micro.getInicio().plus(Duration.ofHours(2)) : micro.getFin() )
    //         .name(micro.getName())
    //         .nombrePonente(micro.getNombrePonente())
    //         .description(micro.getDescription())
    //         .enlaces(micro.getEnlaces())
    //         .build();
    //     microevento = createmicroevento(microevento);
        
    //     if (microevento != null) {
    //         MicroEvento aux = microevento;
    //         List <UserMicroE> asignados = micro.getAsignadosIds()
    //             .stream().map(
    //                 asignado -> UserMicroE.builder()
    //                 .user(userRepository.getOne(Long.parseLong(asignado)))
    //                 .microevento(aux)
    //                 .responsable(true)
    //                 .build()
    //             )
    //             .collect(java.util.stream.Collectors.toList());
    //         microUserRepository.saveAll(asignados);
    //     }
    //     return microevento;
    // }
    @Transactional
    public MicroEvento updatemicroevento(MicroEvento micro) {
        return microRepository.save(micro);
    }


    public List<MicroEvento> findAll(){
        return microRepository.findAll();
    }

    public List<MicroEvento> findAllMicroeventoStatusPendiente(GeneralStatus status){

        return microRepository.findMicroEventoByStatus(status);
    }

    @Transactional
    public void deletemicroevento(Long id) {
        microRepository.deleteById(id);
    }

    @Transactional
    public List<UserMicroE> createAsignados(MicroEventoAsigRequest micro) {
        MicroEvento microevt = microRepository.getOne(micro.getMicroeventId());
        List <UserMicroE> asignados = micro.getAsignadosIds()
            .stream().map(
                asignado -> UserMicroE.builder()
                .user(userRepository.getOne(asignado))
                .microevento(microevt)
                .responsable(true)
                .build()
            )
            .collect(java.util.stream.Collectors.toList());
        return microUserRepository.saveAll(asignados);
    }

    @Transactional
    public List<UserMicroE> updateAsignados(MicroEventoAsigRequest micro) {
        List <UserMicroE> asignados = micro.getAsignadosIds()
            .stream().map(
                asignado -> {
                    UserMicroE aux = microUserRepository.getOneByUserIdAndMicroeventoId(
                        asignado, micro.getMicroeventId());
                    aux.setResponsable(true);
                    return aux;
                }
            )
            .collect(java.util.stream.Collectors.toList());
        return microUserRepository.saveAll(asignados);
    }
    @Transactional
    public List<UserMicroE> removeAsignados(MicroEventoAsigRequest micro) {
        List <UserMicroE> asignados = microUserRepository.findAllById(micro.getAsignadosIds());
        asignados.forEach(
            (UserMicroE a) -> { a.setResponsable(false); }
        );
        return microUserRepository.saveAll(asignados);
    }

    @Transactional (readOnly = true)
    public List<UserMicroE> getAsignadosByMicroeventoId(Long microeventId) {
        return microUserRepository.findByUserId(microeventId);
    }
    @Transactional (readOnly = true)
    public List<UserMicroE> getMicroEventosByUserId(Long userId) {
        return microUserRepository.findByUserId(userId);
    }

}

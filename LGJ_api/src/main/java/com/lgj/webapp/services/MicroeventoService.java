package com.lgj.webapp.services;

import java.time.Duration;
import java.util.List;

import com.lgj.webapp.CompositeKeys.UserMicroKey;
import com.lgj.webapp.dto.MicroEventoAsigRequest;
import com.lgj.webapp.dto.MicroEventoOrgResponse;
import com.lgj.webapp.entities.MicroEvento;
import com.lgj.webapp.entities.UserMicroE;
import com.lgj.webapp.repository.MicroeventoRepository;
import com.lgj.webapp.repository.MicroeventoUserRespository;
import com.lgj.webapp.repository.UserRepository;
import com.lgj.webapp.util.GeneralStatus;
import com.lgj.webapp.util.TipoMicroEvento;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MicroeventoService {
    private MicroeventoRepository microRepository;
    private MicroeventoUserRespository microUserRepository;
    private UserRepository userRepository;

    public MicroeventoService(
        MicroeventoRepository repository, 
        UserRepository userRepository,
        MicroeventoUserRespository microUserRepository) {
        this.microRepository = repository;
        this.userRepository = userRepository;
        this.microUserRepository = microUserRepository;
    }

    @Transactional
    public MicroEvento createmicroevento(MicroEvento micro) {
        return microRepository.save(micro);
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
                .user(userRepository.getOne(Long.parseLong(asignado)))
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
                        Long.parseLong(asignado), micro.getMicroeventId());
                    aux.setResponsable(true);
                    return aux;
                }
            )
            .collect(java.util.stream.Collectors.toList());
        return microUserRepository.saveAll(asignados);
    }

}

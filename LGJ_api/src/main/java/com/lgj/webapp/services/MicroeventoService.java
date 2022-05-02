package com.lgj.webapp.services;

import java.util.List;

import com.lgj.webapp.entities.MicroEvento;
import com.lgj.webapp.repository.MicroeventoRepository;
import com.lgj.webapp.util.GeneralStatus;

import org.springframework.stereotype.Service;

@Service
public class MicroeventoService {
    private MicroeventoRepository microRepository;

    public MicroeventoService(MicroeventoRepository repository) {
        this.microRepository = repository;
    }

    public MicroEvento createmicroevento(MicroEvento micro) {
        return microRepository.save(micro);
    }

    public List<MicroEvento> findAll(){
        return microRepository.findAll();
    }

    public List<MicroEvento> findAllMicroeventoStatusPendiente(GeneralStatus status){

        return microRepository.findMicroEventoByStatus(status);
    }
}

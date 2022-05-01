package com.lgj.webapp.services;

import com.lgj.webapp.entities.MicroEvento;
import com.lgj.webapp.repository.MicroeventoRepository;

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
}

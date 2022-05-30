package com.lgj.webapp.services;

import java.util.List;

import com.lgj.webapp.entities.Distrito;
import com.lgj.webapp.repository.DistritoRepository;

import org.springframework.stereotype.Service;

@Service
public class DistritoService {
    private DistritoRepository distritoRepository;

    public DistritoService(DistritoRepository repository) {
        this.distritoRepository = repository;
    }
    public List<Distrito> getAll(){
        return distritoRepository.findAll();
    }
}

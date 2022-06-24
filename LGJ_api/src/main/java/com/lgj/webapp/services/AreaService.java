package com.lgj.webapp.services;

import java.util.List;

import com.lgj.webapp.entities.Area;
import com.lgj.webapp.repository.AreaRespository;

import org.springframework.stereotype.Service;

@Service
public class AreaService {
    private AreaRespository areaRepository;

    public AreaService(AreaRespository repository) {
        this.areaRepository = repository;
    }
    public List<Area> getAll(){
        return areaRepository.findAll();
    }
}

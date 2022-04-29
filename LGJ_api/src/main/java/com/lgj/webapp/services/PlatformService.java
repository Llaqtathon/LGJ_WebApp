package com.lgj.webapp.services;

import java.util.List;

import com.lgj.webapp.entities.Platform;
import com.lgj.webapp.repository.PlatformRepository;

import org.springframework.stereotype.Service;

@Service 
public class PlatformService {
    private PlatformRepository platformRepository;

    public List < Platform > findAll() {
        return platformRepository.findAll();
    }
}
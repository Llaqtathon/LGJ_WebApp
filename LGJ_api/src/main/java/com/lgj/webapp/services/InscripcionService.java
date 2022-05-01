package com.lgj.webapp.services;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.lgj.webapp.entities.Inscripcion;
import com.lgj.webapp.repository.InscripcionRepository;
import com.lgj.webapp.util.GeneralStatus;

import org.springframework.stereotype.Service;

@Service
public class InscripcionService {

    private InscripcionRepository inscripcionRepository;

    public InscripcionService(InscripcionRepository repository) {
    this.inscripcionRepository = repository;
  }

    //@Transactional(readOnly = true)
    public Inscripcion findById(Long id) {
    return inscripcionRepository.findByid(id);
  }
    @Transactional(readOnly = true)
    public List<Inscripcion> getAllInscripcionByUserId(Long user_id) {
    return inscripcionRepository.findInscripcionsbyUserId(user_id);
  }

  public List<Inscripcion> getAllConfirmadoInscripcionsByUser(Long user_id, GeneralStatus status){
    return inscripcionRepository.findInscripcionsByuserIdAndStatus(user_id, status);
  }

     public Inscripcion updateStatus(Inscripcion inscripcion){
        return inscripcionRepository.save(inscripcion);
    }

}

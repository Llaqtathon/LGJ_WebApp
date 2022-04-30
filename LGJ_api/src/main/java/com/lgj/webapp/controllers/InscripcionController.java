package com.lgj.webapp.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.lgj.webapp.dto.InscripcionResponse;
import com.lgj.webapp.entities.Inscripcion;
import com.lgj.webapp.services.InscripcionService;
import com.lgj.webapp.util.GeneralStatus;
import com.lgj.webapp.util.InscripcionDtoConverter;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/insc")
public class InscripcionController {
    
    private InscripcionService inscriptionService;
    private InscripcionDtoConverter converter;

    public InscripcionController(InscripcionService inscriptionService, InscripcionDtoConverter converter) {
        this.inscriptionService = inscriptionService;
        this.converter = converter;
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<InscripcionResponse>> findAllUserInscripcion(@PathVariable Long user_id) {
        List<Inscripcion> inscripcion = inscriptionService.getAllInscripcionByUserId(user_id);
        return new ResponseEntity<>(converter.convertEntityToDto(inscripcion), HttpStatus.OK);
    }

    @PatchMapping("/status/{id}/{status}")
    public ResponseEntity<Inscripcion> StatusUpdate(@PathVariable Long id, @PathVariable GeneralStatus status) {
       try{
        Inscripcion inscripcion = inscriptionService.findById(id);
        inscripcion.setStatus(status);
        return new ResponseEntity<Inscripcion>(inscriptionService.updateStatus(inscripcion), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



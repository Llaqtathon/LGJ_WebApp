package com.lgj.webapp.controllers;

import java.util.List;

import com.lgj.webapp.dto.InscripcionRequest;
import com.lgj.webapp.dto.InscripcionResponse;
import com.lgj.webapp.dto.OrderRequest;
import com.lgj.webapp.dto.OrderResponse;
import com.lgj.webapp.entities.Inscripcion;
import com.lgj.webapp.entities.Order;
import com.lgj.webapp.entities.User;
import com.lgj.webapp.services.InscripcionService;
import com.lgj.webapp.util.GeneralStatus;
import com.lgj.webapp.util.InscripcionDtoConverter;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<InscripcionResponse> createInscripcion(@RequestBody Inscripcion request) {
        Inscripcion inscripcion = inscriptionService.createInscripcion(request);
        return new ResponseEntity<>(converter.convertEntityToDto(inscripcion), HttpStatus.CREATED);
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<InscripcionResponse>> findAllUserInscripcion(@PathVariable Long user_id) {
        List<Inscripcion> inscripcion = inscriptionService.getAllInscripcionByUserId(user_id);
        return new ResponseEntity<>(converter.convertEntityToDto(inscripcion), HttpStatus.OK);
    }

    @GetMapping("/user/{user_id}/{status}")
    public ResponseEntity<List<InscripcionResponse>> findAllUserInscripcionCumplido(@PathVariable Long user_id, @PathVariable GeneralStatus status) {
        List<Inscripcion> inscripcion = inscriptionService.getAllConfirmadoInscripcionsByUser(user_id, status);
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



package com.lgj.webapp.controllers;

import java.util.List;

import com.lgj.webapp.entities.Distrito;
import com.lgj.webapp.services.DistritoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distritos")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    public DistritoController(DistritoService distritoService) {
        this.distritoService = distritoService; 
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping
    public ResponseEntity<List<Distrito>> findAllDistritos() {
        List<Distrito> distritos = distritoService.getAll();
        return new ResponseEntity<>(distritos, HttpStatus.OK);
    }
}

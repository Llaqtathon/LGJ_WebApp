package com.lgj.webapp.controllers;

import java.util.List;

import com.lgj.webapp.entities.MicroEvento;
import com.lgj.webapp.services.MicroeventoService;
import com.lgj.webapp.util.GeneralStatus;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/micro")
public class MicroeventoController {
    private MicroeventoService microeventoService;

    public MicroeventoController(MicroeventoService microeventoService){
        this.microeventoService=microeventoService;
    }

    @PostMapping
    public ResponseEntity<MicroEvento> createUser(@RequestBody MicroEvento request) {
        return new ResponseEntity<MicroEvento>(microeventoService.createmicroevento(request), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MicroEvento>> FindAll() {
        List<MicroEvento> micro = microeventoService.findAll();
        return new ResponseEntity<>(micro, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<MicroEvento>> findAllMicroeventoStatusPendiente(@PathVariable GeneralStatus status) {
        List<MicroEvento> micro = microeventoService.findAllMicroeventoStatusPendiente(status);
        return new ResponseEntity<>(micro, HttpStatus.OK);
    }
    
}

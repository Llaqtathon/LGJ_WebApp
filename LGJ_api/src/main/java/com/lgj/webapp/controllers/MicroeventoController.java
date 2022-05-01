package com.lgj.webapp.controllers;

import com.lgj.webapp.entities.MicroEvento;
import com.lgj.webapp.services.MicroeventoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

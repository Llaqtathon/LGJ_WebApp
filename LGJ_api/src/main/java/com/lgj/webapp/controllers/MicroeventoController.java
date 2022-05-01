package com.lgj.webapp.controllers;

import java.util.List;

import com.lgj.webapp.dto.MicroEventoAsigRequest;
import com.lgj.webapp.dto.MicroEventoOrgResponse;
import com.lgj.webapp.entities.MicroEvento;
import com.lgj.webapp.entities.UserMicroE;
import com.lgj.webapp.services.MicroeventoService;
import com.lgj.webapp.util.MicroeventDtoConverter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/micro")
public class MicroeventoController {
    private MicroeventoService microeventoService;
    private MicroeventDtoConverter converter;

    public MicroeventoController(
        MicroeventoService microeventoService, MicroeventDtoConverter converter) {
        this.microeventoService=microeventoService;
        this.converter=converter;
    }

    @PostMapping
    public ResponseEntity<MicroEvento> createUser(@RequestBody MicroEvento request) {
        return new ResponseEntity<MicroEvento>(microeventoService.createmicroevento(request), HttpStatus.CREATED);
    }

    // @PostMapping
    // public ResponseEntity<MicroEventoOrgResponse> createMicroEvent(
    //     @RequestBody MicroEventoAsigRequest request) {
    //     MicroEvento microEvento = microeventoService.createFull(request);
    //     return new ResponseEntity<>(converter.convertMicroevntToDto(microEvento), HttpStatus.CREATED);
    //     // return new ResponseEntity<>(converter.convertMentorAreaToDto(mentorAreas), HttpStatus.OK);
    //     // return new ResponseEntity<MicroEvento>(, HttpStatus.CREATED);
    // }
    // @GetMapping
    // public ResponseEntity<MicroEvento> getUser() {
    //     return new ResponseEntity<MicroEvento>(microeventoService.getmicroevento(), HttpStatus.OK);
    // }
    @PostMapping("/asignados")
    public ResponseEntity<List<MicroEventoOrgResponse>> asignMicroEvent(
        @RequestBody MicroEventoAsigRequest request) {
        List<UserMicroE> microEvento = microeventoService.createAsignados(request);
        return new ResponseEntity<>(converter.convertMicroevntAsignToDto(microEvento), HttpStatus.CREATED);
    }
    @PutMapping("/asignados")
    public ResponseEntity<List<MicroEventoOrgResponse>> deleteMicroEvent(
        @RequestBody MicroEventoAsigRequest request) {
        List<UserMicroE> microEvento = microeventoService.updateAsignados(request);
        return new ResponseEntity<>(converter.convertMicroevntAsignToDto(microEvento), HttpStatus.CREATED);
    }
}

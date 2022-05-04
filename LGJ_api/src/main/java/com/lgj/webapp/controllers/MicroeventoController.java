package com.lgj.webapp.controllers;

import java.util.List;


import com.lgj.webapp.dto.MicroEventoAsigRequest;
import com.lgj.webapp.dto.MicroEventoOrgResponse;
import com.lgj.webapp.dto.MicroevntRequest;
import com.lgj.webapp.dto.UserOrgShort;
import com.lgj.webapp.entities.MicroEvento;
import com.lgj.webapp.entities.UserMicroE;
import com.lgj.webapp.services.MicroeventoService;

import com.lgj.webapp.util.GeneralStatus;

import com.lgj.webapp.util.MicroeventDtoConverter;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MicroEventoOrgResponse>> getAllMicroEventos(
        @PathVariable Long userId) {
        List<UserMicroE> microevent =
            microeventoService.getMicroEventosByUserId(userId);
        return new ResponseEntity<>(converter.convertUseMicroToEventDto(microevent), HttpStatus.OK);
    }
    @GetMapping("/edition/{editionId}")
    public ResponseEntity<List<MicroEventoOrgResponse>> getAllMicroEventosByEdition(
        @PathVariable Long editionId) {
        List<MicroEvento> microevent =
            microeventoService.getmicroeventoByEditionId(editionId);
        return new ResponseEntity<>(converter.convertMicroevntToDto(microevent), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<MicroEventoOrgResponse> createMicroEvent(@RequestBody MicroevntRequest request) {
        return new ResponseEntity<>(
            converter.convertMicroevntToDto(microeventoService.createmicroevento(request)),
            HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MicroEventoOrgResponse> updateMicroEvent(
        @PathVariable Long id, @RequestBody MicroevntRequest request) {
        return new ResponseEntity<>(
            converter.convertMicroevntToDto(microeventoService.updatemicroevento(id, request)),
            HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MicroEventoOrgResponse> getById(@PathVariable Long id) {
        return new ResponseEntity<>(
            converter.convertMicroevntToDto(microeventoService.getmicroeventoById(id)), HttpStatus.OK);
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
    

    // @PostMapping
    // public ResponseEntity<MicroEventoOrgResponse> createMicroEvent(
    //     @RequestBody MicroEventoAsigRequest request) {
    //     MicroEvento microEvento = microeventoService.createFull(request);
    //     return new ResponseEntity<>(converter.convertMicroevntToDto(microEvento), HttpStatus.CREATED);
    //     // return new ResponseEntity<>(converter.convertMentorAreaToDto(mentorAreas), HttpStatus.OK);
    //     // return new ResponseEntity<MicroEvento>(, HttpStatus.CREATED);
    // }
    @PostMapping("/asignados")
    public ResponseEntity<List<UserOrgShort>> asignMicroEvent(
        @RequestBody MicroEventoAsigRequest request) {
        List<UserMicroE> microEvento = microeventoService.createAsignados(request);
        return new ResponseEntity<>(converter.convertMicroevntAsignToDto(microEvento), HttpStatus.CREATED);
    }
    // @PutMapping("/asignados")
    // public ResponseEntity<List<MicroEventoOrgResponse>> deleteMicroEvent(
    //     @RequestBody MicroEventoAsigRequest request) {
    //     List<UserMicroE> microEvento = microeventoService.updateAsignados(request);
    //     return new ResponseEntity<>(converter.convertMicroevntAsignToDto(microEvento), HttpStatus.CREATED);
    // }
    @GetMapping("/asignados/{microeventId}")
    public ResponseEntity<List<UserOrgShort>> getAsignados(@PathVariable Long microeventId) {
        List<UserMicroE> microEvento = microeventoService.getAsignadosByMicroeventoId(microeventId);
        return new ResponseEntity<>(converter.convertMicroevntAsignToDto(microEvento), HttpStatus.OK);
    }
}

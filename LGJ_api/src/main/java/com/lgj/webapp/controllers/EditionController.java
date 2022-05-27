package com.lgj.webapp.controllers;

import java.util.ArrayList;
import java.util.List;

import com.lgj.webapp.dto.EditionRequest;
import com.lgj.webapp.dto.EditionResponse;
import com.lgj.webapp.entities.Edition;
import com.lgj.webapp.services.EditionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editions")
public class EditionController {
    private EditionService editionService;

    public EditionController(EditionService editionService){ this.editionService=editionService;}

    @PostMapping
    public ResponseEntity<Edition> createEdition(@RequestBody EditionRequest request){
        Edition edition = editionService.createEdition(request);
        return new ResponseEntity<Edition>(edition, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EditionResponse>> findAllEditions(){
        List<EditionResponse> editions = new ArrayList<>();

        return new ResponseEntity<>(editions, HttpStatus.OK);
    }
}


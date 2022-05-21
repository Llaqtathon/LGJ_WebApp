package com.lgj.webapp.controllers;
/*
import java.util.List;

import com.lgj.webapp.dto.EditionRequest;
import com.lgj.webapp.entities.Edition;
import com.lgj.webapp.services.EditionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name="/api/v1/editions")
public class EditionController {
    private EditionService editionService;

    public EditionController(EditionService editionService){ this.editionService=editionService;}

    @PostMapping
    public ResponseEntity<Edition> createEdition(@RequestBody EditionRequest request){
        return new ResponseEntity<Edition>(editionService.createEdition(request), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Edition>> findAllEditions(){
        List<EditionResponse> editions = new ArrayList<>();

        return new EditionResponse(editions, HttpStatus.OK);
    }
}
*/

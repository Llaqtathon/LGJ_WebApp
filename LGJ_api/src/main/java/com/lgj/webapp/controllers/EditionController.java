package com.lgj.webapp.controllers;

import java.util.ArrayList;
import java.util.List;

import com.lgj.webapp.dto.EditionRequest;
import com.lgj.webapp.dto.EditionResponse;
import com.lgj.webapp.dto.GameResponse;
import com.lgj.webapp.entities.Edition;
import com.lgj.webapp.entities.Game;
import com.lgj.webapp.services.EditionService;
import com.lgj.webapp.util.EditionConverter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editions")
public class EditionController {
    private EditionService editionService;
    private EditionConverter editionConverter;

    public EditionController(EditionService editionService, EditionConverter editionConverter){ 
        this.editionService=editionService;
        this.editionConverter=editionConverter;
    }

    @PostMapping
    public ResponseEntity<Edition> createEdition(@RequestBody EditionRequest request){
        Edition edition = editionService.createEdition(request);
        return new ResponseEntity<Edition>(edition, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EditionResponse>> findAllEditions(){
        List<Edition> editions = editionService.getAll();

        return new ResponseEntity<List<EditionResponse>>(
            this.editionConverter.convertEntityToDto(editions), HttpStatus.OK
        );
    }

    @GetMapping("/{editionId}/games")
    public ResponseEntity<List<GameResponse>> findAllGamesByEditionId(@PathVariable Long editionId){
        List<Game> games = editionService.findAllGamesByEditionId(editionId);

        return new ResponseEntity<List<GameResponse>>(
            this.editionConverter.convertGameEntityToDto(games), HttpStatus.OK);
    }
}


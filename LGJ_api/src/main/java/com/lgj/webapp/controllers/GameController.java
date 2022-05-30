package com.lgj.webapp.controllers;

import java.util.List;

import com.lgj.webapp.dto.GameRequest;
import com.lgj.webapp.dto.GameResponse;
import com.lgj.webapp.entities.Game;
import com.lgj.webapp.services.GameService;
import com.lgj.webapp.util.EditionConverter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {
    private final EditionConverter editionConverter;
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameResponse>> findAllGames() {
        List<Game> games = gameService.getAll();
        return new ResponseEntity<>(this.editionConverter.convertGameEntityToDto(games), HttpStatus.OK);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GameResponse> findGameById(@PathVariable Long gameId) {
        Game game = gameService.getById(gameId);
        return new ResponseEntity<>(this.editionConverter.convertGameEntityToDto(game), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GameResponse> createGame(@RequestBody GameRequest request) {
        Game game = gameService.createGame(request);
        return new ResponseEntity<>(this.editionConverter.convertGameEntityToDto(game), HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GameResponse>> findAllByUserId(@PathVariable Long userId) {
        List<Game> games = gameService.getAllByUserId(userId);
        return new ResponseEntity<>(this.editionConverter.convertGameEntityToDto(games), HttpStatus.OK);
    }
}
package com.lgj.webapp.controllers;

import java.util.List;

import com.lgj.webapp.dto.GameRequest;
import com.lgj.webapp.entities.Game;
import com.lgj.webapp.services.GameService;

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

    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> findAllGames() {
        List<Game> games = gameService.getAll();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<Game> findGameById(@PathVariable Long gameId) {
        Game game = gameService.getById(gameId);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody GameRequest request) {
        Game game = gameService.createGame(request);
        return new ResponseEntity<>(game, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Game>> findAllByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(gameService.getAllByUserId(userId), HttpStatus.OK);
    }
}
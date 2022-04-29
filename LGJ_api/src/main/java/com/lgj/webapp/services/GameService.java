package com.lgj.webapp.services;

import java.util.List;

import com.lgj.webapp.dto.GameRequest;
import com.lgj.webapp.entities.Game;
import com.lgj.webapp.repository.GameRepository;
import com.lgj.webapp.exception.GameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public Game createGame(GameRequest gameRequest){
		return gameRepository.save(new Game(gameRequest));
    }

    public List<Game> getAll(){
        return gameRepository.findAll();
    }

    public Game getById(Long gameId){
        return gameRepository.findById(gameId)
        .orElseThrow(() -> new GameNotFoundException("Game not found with id: " + gameId));
    }
}
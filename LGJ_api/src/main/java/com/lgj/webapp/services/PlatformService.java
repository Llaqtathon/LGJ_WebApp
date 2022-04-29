package com.lgj.webapp.services;

import java.util.List;

import com.lgj.webapp.dto.GameRequest;
import com.lgj.webapp.entities.Platform;
import com.lgj.webapp.repository.GameRepository;
import com.lgj.webapp.exception.GameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class PlatformService {

    private final GameRepository gameRepository;

    public Platform createGame(GameRequest gameRequest){
		return gameRepository.save(new Game(gameRequest));
    }

    public List<Platform> getAll(){
        return gameRepository.findAll();
    }

    public Platform getById(Long gameId){
        return gameRepository.findById(gameId)
        .orElseThrow(() -> new GameNotFoundException("Game not found with id: " + gameId));
    }
}
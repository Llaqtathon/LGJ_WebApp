package com.lgj.webapp.services;

import java.util.ArrayList;
import java.util.List;

import com.lgj.webapp.dto.GameRequest;
import com.lgj.webapp.entities.Game;
import com.lgj.webapp.entities.User;
import com.lgj.webapp.exception.UserNotFoundException;
import com.lgj.webapp.repository.GameRepository;
import com.lgj.webapp.exception.GameNotFoundException;
import com.lgj.webapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;

    public Game createGame(GameRequest gameRequest) {
        return gameRepository.save(new Game(gameRequest));
    }

    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    public Game getById(Long gameId) {
        return gameRepository.findById(gameId)
                .orElseThrow(() -> new GameNotFoundException("Game not found with id: " + gameId));
    }

    public List<Game> getAllByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
        List<Game> games = new ArrayList<>();
        user.getGroups().forEach(group -> games.add(group.getGame()));
        return games;
    }
}
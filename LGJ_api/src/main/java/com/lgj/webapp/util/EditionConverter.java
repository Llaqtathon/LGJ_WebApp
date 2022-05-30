package com.lgj.webapp.util;

import com.lgj.webapp.dto.EditionResponse;
import com.lgj.webapp.dto.GameResponse;
import com.lgj.webapp.entities.Edition;
import com.lgj.webapp.entities.Game;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EditionConverter {
    private ModelMapper modelMapper;

    public EditionConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public EditionResponse convertEntityToDto(Edition edition) {
        return modelMapper.map(edition, EditionResponse.class);
    }

    public List<EditionResponse> convertEntityToDto(List<Edition> editions) {
        return editions.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public GameResponse convertGameEntityToDto(Game game) {
        return modelMapper.map(game, GameResponse.class);
    }

    public List<GameResponse> convertGameEntityToDto(List<Game> games) {
        return games.stream()
                .map(this::convertGameEntityToDto)
                .collect(Collectors.toList());
    }
}

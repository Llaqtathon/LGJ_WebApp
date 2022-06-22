package com.lgj.webapp.util;

import com.lgj.webapp.dto.SignupRequestDto;
import com.lgj.webapp.dto.UserDto;
import com.lgj.webapp.entities.User;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    private final ModelMapper modelMapper;

    public UserConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDto convertEntityToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public List<UserDto> convertEntityToDto(List<User> users) {
        return users.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    
    public User signup(SignupRequestDto signupRequestDto){
        return modelMapper.map(signupRequestDto, User.class);
    }
}

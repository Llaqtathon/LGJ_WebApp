package com.lgj.webapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lgj.webapp.dto.LoginRequestDto;
import com.lgj.webapp.dto.LoginResponseDto;
import com.lgj.webapp.dto.SignupRequestDto;
import com.lgj.webapp.dto.UserDto;
import com.lgj.webapp.entities.User;
import com.lgj.webapp.services.UserService;
import com.lgj.webapp.util.UserConverter;

@RestController
public class LoginController {
    private final UserService userService;

    private final UserConverter userConverter;

    public LoginController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/signup")
    public ResponseEntity<UserDto> createUser(@RequestBody User request) {
        User user = userService.createUser(request);
        return new ResponseEntity<UserDto>(userConverter.convertEntityToDto(user), HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request){
        LoginResponseDto loginResponseDto=userService.login(request);
        return new ResponseEntity<LoginResponseDto>(loginResponseDto, HttpStatus.OK);
    }

    
}

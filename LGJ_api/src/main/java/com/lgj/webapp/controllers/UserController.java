package com.lgj.webapp.controllers;

import com.lgj.webapp.entities.User;
import com.lgj.webapp.services.UserService;
//import com.lgj.webapp.util.EntityDtoConverter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User request) {
        return new ResponseEntity<User>(userService.createUser(request), HttpStatus.CREATED);
    }
}

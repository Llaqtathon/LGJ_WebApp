package com.lgj.webapp.controllers;

import com.lgj.webapp.dto.InscripcionResponse;
import com.lgj.webapp.dto.UserDto;
import com.lgj.webapp.entities.Inscripcion;
import com.lgj.webapp.entities.User;
import com.lgj.webapp.services.UserService;
//import com.lgj.webapp.util.EntityDtoConverter;

import com.lgj.webapp.util.GeneralStatus;
import com.lgj.webapp.util.InscripcionDtoConverter;
import com.lgj.webapp.util.RolSelection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private InscripcionDtoConverter converter;

    public UserController(UserService userService,  InscripcionDtoConverter converter){
        this.userService=userService;
        this.converter = converter;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User request) {
        return new ResponseEntity<User>(userService.createUser(request), HttpStatus.CREATED);
    }

    @GetMapping("/{rol}")
    public ResponseEntity<List<User>> findParticipantByRol(@PathVariable RolSelection rol) {
        List<User> user = userService.getAllParticipantByRol(rol);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

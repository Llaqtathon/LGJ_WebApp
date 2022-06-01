package com.lgj.webapp.controllers;

import com.lgj.webapp.dto.InscripcionResponse;
import com.lgj.webapp.dto.OrderResponse;
import com.lgj.webapp.dto.UserDto;
import com.lgj.webapp.entities.Inscripcion;
import com.lgj.webapp.entities.User;
import com.lgj.webapp.services.UserService;
//import com.lgj.webapp.util.EntityDtoConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lgj.webapp.util.InscripcionDtoConverter;
import com.lgj.webapp.util.RolSelection;
import com.lgj.webapp.util.UserConverter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private UserConverter userConverter;
    private InscripcionDtoConverter converter;

    public UserController(UserService userService, InscripcionDtoConverter converter, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
        this.converter = converter;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody User request) {
        User user = userService.createUser(request);
        return new ResponseEntity<UserDto>(userConverter.convertEntityToDto(user), HttpStatus.CREATED);
    }
    @GetMapping("/{id}/{rol}")
    public ResponseEntity<UserDto> findParticipant(@PathVariable Long id, @PathVariable RolSelection rol) {
        User user = userService.findById(id);
        user.setRol(rol);
        return new ResponseEntity<UserDto>(userConverter.convertEntityToDto(user), HttpStatus.OK);
    }
    @PatchMapping("/{id}/{rol}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @PathVariable RolSelection rol, @RequestBody User userDetails) {
        User user = userService.findById(id);
        try{
            user.setNombres(userDetails.getNombres());
            user.setApellidos(userDetails.getApellidos());
            user.setTelefono(userDetails.getTelefono());
            user.setEmail(userDetails.getEmail());
            user.setDni(userDetails.getDni());
            user.setRol(rol);

            User updatedUser = userService.updateUser(user);
            
            return new ResponseEntity<UserDto>(userConverter.convertEntityToDto(updatedUser), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{rol}")
    public ResponseEntity<List<UserDto>> findParticipantByRol(@PathVariable RolSelection rol) {
        List<User> user = userService.getParticipantsByRol(rol);
        return new ResponseEntity<List<UserDto>>(userConverter.convertEntityToDto(user), HttpStatus.OK);
    }
}


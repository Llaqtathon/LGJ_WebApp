package com.lgj.webapp.util;

import com.lgj.webapp.entities.User;

import com.lgj.webapp.exception.IncorrectRequestException;

public class UserValidator {
    public static void validate(User user){
        if(user.getUsername()==null || user.getUsername().trim().isEmpty()){
            throw new IncorrectRequestException("El nombre de usuario es requerido");
        }

        if(user.getUsername().length()>30){
            throw new IncorrectRequestException("El nombre de usuario es muy largo (max 30)");
        }

        if(user.getPassword()==null || user.getPassword().isEmpty()){
            throw new IncorrectRequestException("El password es requerido");
        }
        if(user.getPassword().length()>30){
            throw new IncorrectRequestException("El password de usuario es muy largo (max 30)");
        }
    }
}

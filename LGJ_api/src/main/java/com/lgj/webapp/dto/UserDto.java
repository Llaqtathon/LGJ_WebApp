package com.lgj.webapp.dto;

import lombok.Data;

import java.time.LocalDate;



@Data
public class UserDto {
    private Long id;
    
    private String username;
    //private String password;
    private String nombres;
    private String apellidos;
    private String email;
    private LocalDate nacimiento;
    private String telefono;
    private DistritoDto distrito;
    private String DNI;
    private String descripcion;
    private String foto_perfil_url;
    private String genero;
    //private RolSelection rol;
}

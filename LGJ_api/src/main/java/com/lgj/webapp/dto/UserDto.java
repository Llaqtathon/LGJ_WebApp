package com.lgj.webapp.dto;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.lgj.webapp.entities.Distrito;
import com.lgj.webapp.util.RolSelection;

@Data
public class UserDto {
    private Long id;
    
    private String username;
    //private String password;
    private String nombres;
    private String apellidos;
    private String email;
    private LocalDate nacimiento;
    @NotBlank
    @NotNull
    private String telefono;
    @NotBlank
    @NotNull
    private DistritoDto distrito;
    private String DNI;
    private String descripcion;
    private String foto_perfil_url;
    private String genero;
    //private RolSelection rol;
}

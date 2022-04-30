package com.lgj.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.lgj.webapp.entities.Distrito;
import com.lgj.webapp.util.RolSelection;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    
    private String username;
    private String password;
    private String nombres;
    private String apellidos;
    private String email;
    private Date nacimiento;
    @NotBlank
    @NotNull
    private String telefono;
    @NotBlank
    @NotNull
    private Distrito distritoId;
    private String DNI;
    private String descripcion;
    private String foto_perfil_url;
    private String genero;
    private RolSelection rol;
}

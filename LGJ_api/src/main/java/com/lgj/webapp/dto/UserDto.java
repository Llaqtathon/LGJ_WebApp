package com.lgj.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.lgj.webapp.entities.Distrito;
import com.lgj.webapp.util.GenderSelection;
import com.lgj.webapp.util.RolSelection;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotBlank
    @NotNull
    private String username;
    @NotBlank
    @NotNull
    private String password;
    @NotBlank
    @NotNull
    private String nombres;
    @NotBlank
    @NotNull
    private String apellidos;
    @NotBlank
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    private Date nacimiento;
    @NotBlank
    @NotNull
    private String telefono;
    @NotBlank
    @NotNull
    private Distrito distritoId;
    @NotBlank
    @NotNull
    private String DNI;
    private String descripcion;
    private String foto_perfil_url;
    @NotBlank
    @NotNull
    private GenderSelection genero;
    @NotBlank
    @NotNull
    private RolSelection rol;
}

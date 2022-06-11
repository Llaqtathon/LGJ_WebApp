package com.lgj.webapp.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.lgj.webapp.entities.Distrito;
import com.lgj.webapp.util.RolSelection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDto {
    private String username;
    private String password;
    private String nombres;
    private String apellidos;
    private String email;
    private LocalDate nacimiento;
    @NotBlank
    @NotNull
    private String telefono;
    @NotBlank
    @NotNull
    private Distrito distrito_id;
    private String DNI;
    //private String descripcion;
    //private String foto_perfil_url;
    private String genero;
    private RolSelection rol;
}

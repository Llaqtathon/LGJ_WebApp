package com.lgj.webapp.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.lgj.webapp.entities.Distrito;
import com.lgj.webapp.util.GenderSelection;
import com.lgj.webapp.util.RolSelection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class SignupRequestDto {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    @NotBlank
    @Size(max = 20)
    private String password;
    @NotBlank
    @Size(min = 3, max = 100)
    private String nombres;
    @NotBlank
    @Size(min = 3, max = 100)
    private String apellidos;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    //@NotBlank
    private LocalDate nacimiento;
    @NotBlank
    @Size(min=9, max = 9)
    @NotNull
    private String telefono;
    private Distrito distrito;
    @NotBlank
    @Size(min=8, max = 8)
    @NotNull
    private String dni;
    @NotBlank
    @NotNull
    private String genero;
    private Set<String> role;
    @Nullable
    private String descripcion;
    @Nullable
    private String foto_perfil_url;

    public String getUsername() {
        return username;
      }
      public void setUsername(String username) {
        this.username = username;
      }
      public String getEmail() {
        return email;
      }
      public void setEmail(String email) {
        this.email = email;
      }
      public String getPassword() {
        return password;
      }
      public void setPassword(String password) {
        this.password = password;
      }
      public Set<String> getRole() {
        return role;
      }
      public void setRole(Set<String> role) {
        this.role = role;
      }
      public String getNombres() {
        return nombres;
      }
      public void setNombres(String nombres) {
        this.nombres = nombres;
      }
      public String getApellidos() {
        return apellidos;
      }
      public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
      }
      public String getTelefono() {
        return telefono;
      }
      public void setTelefono(String telefono) {
        this.telefono = telefono;
      }
      public String getDni() {
        return dni;
      }
      public void setDni(String dni) {
        this.dni = dni;
      }
      public LocalDate getNacimiento() {
        return nacimiento;
      }
      public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
      }
      public Distrito getDistrito() {
        return distrito;
      }
      public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
      }
      public String getGenero() {
        return genero;
      }
      public void setGenero(String genero) {
        this.genero = genero;
      }
      public String getDescripcion() {
        return descripcion;
      }
      public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
      }
      public String getFoto() {
        return foto_perfil_url;
      }
      public void setFoto(String foto_perfil_url) {
        this.foto_perfil_url = foto_perfil_url;}
    }

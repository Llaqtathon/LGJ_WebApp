package com.lgj.webapp.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lgj.webapp.util.GenderSelection;
import com.lgj.webapp.util.RolSelection;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Users")
public class User{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "username", nullable = false)
  private String username;
  @Column(name = "password", nullable = false)
  private String password;
  @Column(name = "nombres", nullable = false)
  private String nombres;
  @Column(name = "apellidos", nullable = false)
  private String apellidos;
  @Column(name= "email", nullable = false)
  private String email;
  @Column(name= "nacimiento", nullable = false)
  private LocalDate nacimiento;
  @Column(name= "telefono", nullable = false)
  private String telefono;
  @ManyToOne
  @JoinColumn(name = "distrito_id")
  private Distrito distrito;
  @Column(name= "dni", nullable = false)
  private String dni;
  @Column(name= "descripcion", nullable = true)
  private String descripcion;
  @Column(name= "foto_perfil_url", nullable = true)
  private String foto_perfil_url;
  @Column(name = "genero")
  @Enumerated(value = EnumType.STRING)
  private GenderSelection genero;
  @Column(name = "rol")
  @Enumerated(value = EnumType.STRING)
  private RolSelection rol;

}

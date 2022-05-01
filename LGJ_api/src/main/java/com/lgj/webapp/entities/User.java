package com.lgj.webapp.entities;

import lombok.AllArgsConstructor;
// import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lgj.webapp.util.GenderSelection;
import com.lgj.webapp.util.RolSelection;

import java.util.Date;


@Data
@Entity
@Getter
@Inheritance (strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
// @Builder
@SuperBuilder(toBuilder = true)
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
  private Date nacimiento;
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

  public abstract static class UserBuilder<C extends User, B extends User.UserBuilder<C, B>> {
    protected B $fillValuesFromUser(User instance) {
        $fillValuesFromInstanceIntoBuilder(instance, this);
        return self();
    }
  }
}

package com.lgj.webapp.entities;

import lombok.AllArgsConstructor;
// import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import reactor.util.annotation.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.lgj.webapp.util.GenderSelection;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Getter
@Inheritance (strategy = InheritanceType.JOINED)

@AllArgsConstructor
// @Builder
@SuperBuilder(toBuilder = true)
@Table(name = "users", uniqueConstraints = {
  @UniqueConstraint(columnNames = "username"),
  @UniqueConstraint(columnNames = "email")
})
public class User{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  @Size(max = 20)
  private String username;
  @NotBlank
  //@Size(max = 20)
  private String password;
  @NotBlank
  @Size(max = 100)
  private String nombres;
  @NotBlank
  @Size(max = 100)
  private String apellidos;
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;
  private LocalDate nacimiento;
  @NotBlank
  @Size(max = 9)
  private String telefono;
  @ManyToOne
  @JoinColumn(name = "distrito_id")
  private Distrito distrito;
  @NotBlank
  @Size(max = 8)
  private String dni;
  @Column(name = "descripcion", nullable = true)
  private String descripcion;
  @Column(name = "foto_perfil_url", nullable = true)
  private String foto_perfil_url;
  @NotBlank
  private String genero;
  @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
  @ManyToMany(mappedBy = "users")
    List<Group> groups;

  @OneToMany(mappedBy = "user")
  private Set<UserMicroE> interesado;

  public abstract static class UserBuilder<C extends User, B extends User.UserBuilder<C, B>> {
    protected B $fillValuesFromUser(User instance) {
        $fillValuesFromInstanceIntoBuilder(instance, this);
        return self();
    }
  }
 public User(){}
  public User(String username, String email, String password, String nombres, String apellidos,
  String telefono, String dni, LocalDate nacimiento, Distrito distrito,  String genero) {
      this.username = username;
      this.email = email;
      this.password = password;
      this.nombres = nombres;
      this.apellidos = apellidos;
      this.telefono = telefono;
      this.dni = dni;
      this.nacimiento = nacimiento;
      this.distrito = distrito;
      this.genero = genero;
  }
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
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
  public Set<Role> getRoles() {
    return roles;
  }
  public void setRoles(Set<Role> roles) {
    this.roles = roles;
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
  public String getGenero() {
    return genero;
  }
  public void setGenero(String genero) {
    this.genero = genero;
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
    this.foto_perfil_url = foto_perfil_url;
  }
}

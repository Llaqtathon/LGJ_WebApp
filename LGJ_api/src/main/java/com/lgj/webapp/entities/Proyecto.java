package com.lgj.webapp.entities;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Entity
@Table(name = "proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_proyectoId")
    private Long id;
    @Column(name = "proyectoName", nullable = false)
    private String name;
    @Column(name = "proyectoGrupo", nullable = false)
    private Group grupo;
    @Column(name = "proyectoUrl", nullable = false)
    private String url;
    @Column(name = "proyectoEdition", nullable = false)
    private Edition edicionProyecto;
    @Column(name = "proyectoFoto", nullable = false)
    private String foto;
    @Column(name = "proyectoDescripcion", nullable = false)
    private String descripcion;

    public Long getId() {return id;}
    public String getName() {return name;}
    public Group getGrupo() {return grupo;}
    public String getUrl() {return url;}
    public Edition getEdition() {return edicionProyecto;}
    public String getFoto() {return foto;}
    public String getDescripcion() {return descripcion;}

    public void setId(Long id){this.id =id;}
    public void setName(String name){this.name =name;}
    public void setGroup(Group grupo){this.grupo =grupo;}
    public void setUrl(String url){this.url =url;}
    public void setEdition(Edition edicionProyecto){this.edicionProyecto =edicionProyecto;}
    public void setFoto(String foto){this.foto =foto;}
    public void setDescripcion(String descripcion){this.descripcion =descripcion;}
    
    
}

package com.lgj.webapp.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "highlight")
public class Highlight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pk_highlightId")
    private Long id;
    @Column(name = "highlightTitulo")
    private String titulo;
    @Column(name = "hightlightFoto")
    private String foto;
    @Column(name = "highlightDescripcion")
    private String descripcion;
    //@Column(name = "highlightPosts")
    //private List<Post> publicaciones;

    public Long getId() {return id;}
    public String getTitulo() {return titulo;}
    public String getFoto() {return foto;}
    public String getDescripcion() {return descripcion;}
    //public List<Post> getPublicaciones() {return publicaciones;}

    public void setId(Long id){this.id =id;}
    public void setTitulo(String titulo){this.titulo =titulo;}
    public void setFoto(String foto){this.foto =foto;}
    public void setDescripcion(String descripcion){this.descripcion =descripcion;}
    //public void addPost(Post publicacion){this.publicaciones.add(publicacion);}

}

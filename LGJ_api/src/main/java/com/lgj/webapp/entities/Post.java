package com.lgj.webapp.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="username")
    private String username;
    @Column(name = "descripcion", nullable = true)
    private String descripcion;
    @Column(name = "foto_post", nullable = true)
    private String foto_post;
    
}

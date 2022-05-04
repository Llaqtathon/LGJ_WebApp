package com.lgj.webapp.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.lgj.webapp.util.RolSelection;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="username", nullable = false)
    private String username;
    @Column(name = "descripcion", nullable = true)
    private String descripcion;
    @Column(name = "foto_post", nullable = true)
    private String foto_post;
}

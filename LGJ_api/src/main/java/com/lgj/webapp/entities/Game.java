package com.lgj.webapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.*;


import com.lgj.webapp.dto.GameRequest;

@Data
@Entity
@Table(name = "games")
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "url_ggj")
    private String urlGGJ;
    @Column(name = "url_icht")
    private String urlIcht;
    @Column(name = "url_additional")
    private String urlAdditional;
    @Column(nullable = false)
    private String description;
    @Column(name = "foto_url")
    private String fotoUrl;
    @ManyToMany
    @JoinTable(
            name = "games_platforms",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "plarform_id"))
    Set<Platform> platforms;

    @OneToOne(mappedBy = "game")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    public Game(GameRequest gameRequest) {
        this.name = gameRequest.getName();
        this.urlGGJ = gameRequest.getUrlGGJ();
        this.urlIcht = gameRequest.getUrlIcht();
        this.urlAdditional = gameRequest.getUrlAdditional();
        this.description = gameRequest.getDescription();
        this.fotoUrl = gameRequest.getFotoUrl();
    }
}
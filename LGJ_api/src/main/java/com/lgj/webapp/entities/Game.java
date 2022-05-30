package com.lgj.webapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import javax.persistence.*;


import com.lgj.webapp.dto.GameRequest;
import com.lgj.webapp.util.PlatformSelection;

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
  
    @OneToOne(mappedBy = "game")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    
    @ElementCollection
    @Enumerated
    private Set<PlatformSelection> platforms;

    public Game(GameRequest gameRequest) {
        this.name = gameRequest.getName();
        this.urlGGJ = gameRequest.getUrlGGJ();
        this.urlIcht = gameRequest.getUrlIcht();
        this.urlAdditional = gameRequest.getUrlAdditional();
        this.description = gameRequest.getDescription();
        this.fotoUrl = gameRequest.getFotoUrl();
        this.platforms = gameRequest.getPlatforms();
    }
}
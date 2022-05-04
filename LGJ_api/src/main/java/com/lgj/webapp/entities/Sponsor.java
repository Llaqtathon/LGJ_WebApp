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
@Table(name = "sponsors")
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pk_sponsorId")
    private Long id;
    @Column(name = "sponsorName", nullable = false)
    private String name;
    @Column(name = "sponsorLogo", nullable = false)
    private String logo;
    @Column(name = "sponsorDescripcion", nullable = false)
    private String descripcion;

    public Long getId(){return id;}
    public String getName(){return name;}
    public String getLogo() {return logo;}
    public String getDescripcion(){return descripcion;}

    public void setId(Long id) {this.id =id;}
    public void setName(String name){this.name=name;}
    public void setLogo(String logo){this.logo =logo;}
    public void setDescripcion(String descripcion){this.descripcion =descripcion;}

}

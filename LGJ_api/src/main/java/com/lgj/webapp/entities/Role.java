package com.lgj.webapp.entities;

import javax.persistence.*;

import com.lgj.webapp.util.RolSelection;
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RolSelection name;
    public Role() {
    }
    public Role(RolSelection name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public RolSelection getName() {
        return name;
    }
    public void setName(RolSelection name) {
        this.name = name;
    } 
}

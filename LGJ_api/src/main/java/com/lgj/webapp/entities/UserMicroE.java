package com.lgj.webapp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.lgj.webapp.CompositeKeys.UserMicroKey;

import lombok.Data;

@Data
@Table(name = "user_microevento")
@Entity
public class UserMicroE {
    @EmbeddedId
    UserMicroKey id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("microeventoId")
    @JoinColumn(name = "microevento_id")
    private MicroEvento microevento;

    @Column(name = "interesado")
    private Boolean interesado;
}

package com.lgj.webapp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.lgj.webapp.CompositeKeys.UserMicroKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "user_microevento")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserMicroE {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Builder.Default
    UserMicroKey id = new UserMicroKey();

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
    @Column(name = "responsable")
    private Boolean responsable;
}

package com.lgj.webapp.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lgj.webapp.util.GeneralStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Inscripcion")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
    @ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "motivo", nullable = false)
    private String motivo;
    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private GeneralStatus status;
    //Aun no se ha creado tabla edicion cuando se cree descomentar
    @ManyToOne
    @JoinColumn(name = "edicion_id")
    private Edition edicion_id;
}

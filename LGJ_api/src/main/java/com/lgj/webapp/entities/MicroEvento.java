package com.lgj.webapp.entities;

import java.time.LocalDateTime;
import java.util.List;
// import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lgj.webapp.util.GeneralStatus;
import com.lgj.webapp.util.TipoMicroEvento;
// import com.lgj.webapp.entities.Edition;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "microevento")
public class MicroEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "edicion_id")
    private Edition edition;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "nombre_ponente", nullable = true)
    private String nombrePonente;
    @Column(name = "description", nullable = true)
    private String description;
    @Column(name = "inicio", nullable = true)
    private LocalDateTime inicio;
    @Column(name = "fin", nullable = true)
    private LocalDateTime fin;
    @Column(name = "tipo")
    @Enumerated(value = EnumType.STRING)
    private TipoMicroEvento tipo;
    @Column(name = "cupo", nullable = true)
    private int cupo;
    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private GeneralStatus status;
    @ManyToMany(mappedBy = "microeventos")
    private List<Cronograma> cronograma;
    
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "microevento")
    // @Fetch(value = FetchMode.SUBSELECT)
    private List<UserMicroE> users;
    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "microevento")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<EnlaceStreaming> enlaces;
}

package com.lgj.webapp.entities;

import java.time.LocalDate;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lgj.webapp.util.GeneralStatus;
import com.lgj.webapp.util.TipoMicroEvento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "microevento")
public class MicroEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "inicio", nullable = false)
    private LocalDate inicio;
    @Column(name = "fin", nullable = false)
    private LocalDate fin;
    @Column(name = "tipo")
    @Enumerated(value = EnumType.STRING)
    private TipoMicroEvento tipo;
    @Column(name = "cupo", nullable = true)
    private int cupo;
    @ManyToMany(mappedBy = "microeventos")
    private List<Cronograma> cronograma;
    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "microevento")
    private List<UserMicroE> users;
    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private GeneralStatus status;
}

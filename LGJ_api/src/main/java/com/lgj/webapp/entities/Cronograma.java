package com.lgj.webapp.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Cronograma")
public class Cronograma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "semana_inicio", nullable = true)
    private LocalDate semana_inicio;
    @Column(name = "semana_fin", nullable = true)
    private LocalDate semana_fin;
    @Column(name = "talleres", nullable = true)
    private Boolean talleres;
    @Column(name = "charlas", nullable = true)
    private Boolean charlas;
    @ManyToMany
    @JoinTable(
    name = "cronograma_microevento", 
    joinColumns = @JoinColumn(name = "cronograma_id"), 
    inverseJoinColumns = @JoinColumn(name = "microevento_id"))
    private Set<MicroEvento> microeventos;
}

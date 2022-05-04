package com.lgj.webapp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.lgj.webapp.CompositeKeys.InscripcionAreaKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table (name = "inscripcion_area")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InscripcionArea {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    InscripcionAreaKey id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("inscripcionId")
    @JoinColumn(name = "inscripcion_id")
    private Inscripcion inscripcion;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("areaId")
    @JoinColumn(name = "area_id")
    private Area area;

    @Column(name = "Selection_Order")
    private Integer SelectionOfOrder;

}

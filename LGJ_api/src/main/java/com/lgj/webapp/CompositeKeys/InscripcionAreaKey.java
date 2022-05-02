package com.lgj.webapp.CompositeKeys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
// import javax.persistence.Entity;

import lombok.Data;

@Data
// @Entity
@Embeddable
public class InscripcionAreaKey implements Serializable {
    @Column(name = "inscripcion_id")
    private Long inscripcionId;
    @Column(name = "area_id")
    private Long areaId;
}

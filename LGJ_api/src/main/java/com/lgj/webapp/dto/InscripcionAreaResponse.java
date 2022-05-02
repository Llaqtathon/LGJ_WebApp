package com.lgj.webapp.dto;

import com.lgj.webapp.util.AreaPriority;

import lombok.Data;

@Data
public class InscripcionAreaResponse {
    // private int id;
    private Integer areaId;
    private Long inscripcionId;
    private String areaName;
    private Integer selectionOfOrder;
}
package com.lgj.webapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.lgj.webapp.util.AreaPriority;

import lombok.Data;

@Data
public class AreaInscripcionRequest {
    @NotBlank
    @NotEmpty
    private Integer areaId;
    private Integer SelectionOfOrder;
}
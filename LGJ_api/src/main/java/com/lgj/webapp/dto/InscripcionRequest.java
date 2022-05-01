package com.lgj.webapp.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class InscripcionRequest {

    @NotBlank
    private Long id;
}

package com.lgj.webapp.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class GroupRequest {

    @NotBlank
    private Long id;
    private String name;
    private String photoUrl;
}
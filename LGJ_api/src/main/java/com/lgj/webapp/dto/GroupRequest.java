package com.lgj.webapp.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class GroupRequest {
    @NotBlank
    private String name;
    private String photoUrl;
    @NotBlank
    private Long editionId;
}
package com.lgj.webapp.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class GroupRequest {
    private String name;
    private String photoUrl;
}
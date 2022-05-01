package com.lgj.webapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PostRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String foto_post;
}

package com.lgj.webapp.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.lgj.webapp.entities.User;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class PostDto {
    private Long id;
    @NotBlank
    @NotNull
    private String username;
    private String descripcion;
    private String foto_post;
}

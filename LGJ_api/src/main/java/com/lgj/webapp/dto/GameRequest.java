package com.lgj.webapp.dto;

import java.util.List;
import javax.validation.constraints.NotBlank;
import com.lgj.webapp.entities.Platform;

import lombok.Data;

@Data
public class GameRequest {
    
    @NotBlank
    private String name;
    @NotBlank
    private String urlGGJ;
    @NotBlank
    private String urlIcht;
    @NotBlank
    private String urlAdditional;
    @NotBlank
    private String description;
    @NotBlank
    private String fotoUrl;
    private List<Platform> platforms;
}
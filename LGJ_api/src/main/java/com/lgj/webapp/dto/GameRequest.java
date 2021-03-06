package com.lgj.webapp.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import com.lgj.webapp.util.PlatformSelection;

import lombok.Data;

@Data
public class GameRequest {
    
    @NotBlank
    private String name;
    private String urlGGJ;
    private String urlIcht;
    private String urlAdditional;
    @NotBlank
    private String description;
    @NotBlank
    private String fotoUrl;
    private Set<PlatformSelection> platforms;
}
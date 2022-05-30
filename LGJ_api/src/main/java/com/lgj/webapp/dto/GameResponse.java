package com.lgj.webapp.dto;

import java.util.List;

import com.lgj.webapp.util.PlatformSelection;

import lombok.Data;

@Data
public class GameResponse {
    private String name;
    private String urlGGJ;
    private String urlIcht;
    private String urlAdditional;
    private String description;
    private String fotoUrl;
    private List<PlatformSelection> platforms;
    private Long group_id;
}
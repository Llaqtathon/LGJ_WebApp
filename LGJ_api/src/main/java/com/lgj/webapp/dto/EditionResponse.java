package com.lgj.webapp.dto;
import java.util.Date;
import lombok.Data;

@Data
public class EditionResponse {
    private Long id;
    private String name;
    private String description;
    private Date dateStart;
    private Date dateEnd;
    private String theme;
    private String location;
    private String locationUrlGmaps;
    private Integer spaceAvailable;
    private Boolean isActive;
}

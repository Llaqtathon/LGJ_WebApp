package com.lgj.webapp.dto;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;
import com.lgj.webapp.entities.Edition;

import lombok.Data;

@Data
public class EditionRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private Date dateStart;
    @NotBlank
    private Date dateEnd;
    @NotBlank
    private String theme;
    @NotBlank
    private String location;
    @NotBlank
    private String locationUrlGmaps;
    @NotBlank
    private List<MentorEdition> mentors;
}

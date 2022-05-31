package com.lgj.webapp.dto;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;

import com.lgj.webapp.entities.MentorEdition;
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
    // private Date dateStartPreproduction;
    // private Date dateEndPostproduction;
    private String theme;
    private Integer spaceAvailable;
    private String location;
    private String locationUrlGmaps;
    private List<MentorEdition> mentors;

//   private Distrito distrito;
}


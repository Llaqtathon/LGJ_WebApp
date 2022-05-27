package com.lgj.webapp.dto;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;

import com.lgj.webapp.entities.MentorEdition;
import lombok.Data;

@Data
public class EditionResponse {
    private String name;
    private String description;
    private Date dateStart;
    private Date dateEnd;
    private String theme;
    private String location;
    private String locationUrlGmaps;
    
    private List<MentorEdition> mentors;
}

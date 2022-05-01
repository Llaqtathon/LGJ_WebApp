package com.lgj.webapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.lgj.webapp.util.AreaPriority;

import lombok.Data;

@Data
public class AreaMentorRequest {
  @NotBlank
  @NotEmpty
  private Integer areaId;
  private Integer yearsOfExperience;
  private AreaPriority priority;
}

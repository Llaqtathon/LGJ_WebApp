package com.lgj.webapp.dto;

import com.lgj.webapp.util.AreaPriority;

import lombok.Data;

@Data
public class MentorAreaResponse {
  // private int id;
  private Integer areaId;
  private Long mentorId;
  private String areaName;
  private Integer yearsOfExperience;
  private AreaPriority priority;
}

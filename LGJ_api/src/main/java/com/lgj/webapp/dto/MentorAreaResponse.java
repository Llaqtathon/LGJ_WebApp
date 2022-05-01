package com.lgj.webapp.dto;

import java.util.Date;

import com.lgj.webapp.util.AreaPriority;

import lombok.Data;

@Data
public class MentorAreaResponse {
  private int id;
  private int areaId;
  private Long mentorId;
  private String name;
  private Date yearsOfExperience;
  private AreaPriority priority;
}

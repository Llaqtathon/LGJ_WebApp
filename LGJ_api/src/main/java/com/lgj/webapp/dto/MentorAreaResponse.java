package com.lgj.webapp.dto;

import com.lgj.webapp.util.AreaPriority;

import lombok.Data;

@Data
public class MentorAreaResponse {
  private int areaId;
  private String name;
  private AreaPriority priority;
}

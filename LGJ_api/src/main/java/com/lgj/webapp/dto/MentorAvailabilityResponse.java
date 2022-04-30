package com.lgj.webapp.dto;

import lombok.Data;

@Data
public class MentorAvailabilityResponse {
  private Integer id;
  private String dateStart;
  private String dateEnd;
}

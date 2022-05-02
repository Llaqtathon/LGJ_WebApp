package com.lgj.webapp.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MentorAvailabilitiesRequest {
  @NotNull
  private Long mentorId;
  @NotNull
  private Long editionId;
  @NotNull
  private List<MentorAvailabilityRequest> availabilities;
}

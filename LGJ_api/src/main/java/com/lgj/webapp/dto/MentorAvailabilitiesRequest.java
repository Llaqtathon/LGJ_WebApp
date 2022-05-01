package com.lgj.webapp.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MentorAvailabilitiesRequest {
  @NotNull
  private Long mentor_id;
  @NotNull
  private Long edition_id;
  @NotNull
  private List<MentorAvailabilityRequest> availabilities;
}

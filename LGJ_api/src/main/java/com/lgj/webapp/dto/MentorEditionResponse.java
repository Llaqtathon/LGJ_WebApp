package com.lgj.webapp.dto;

import java.util.List;

import com.lgj.webapp.util.GeneralStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MentorEditionResponse {
  private Long mentorId;
  private Long editionId;
  private String nombres;
  private String apellidos;
  private String urlPhoto;
  private GeneralStatus status;
  List<MentorAreaResponse> areas;
  List<MentorAvailabilityResponse> availabilities;
}

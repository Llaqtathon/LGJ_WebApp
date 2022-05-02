package com.lgj.webapp.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;

// import com.lgj.webapp.util.GeneralStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MentorResponse {
  private Long mentorId;
  private String nombres;
  private String apellidos;
  private String urlPhoto;
  // private GeneralStatus status;
  List<MentorAreaResponse> areas;
}

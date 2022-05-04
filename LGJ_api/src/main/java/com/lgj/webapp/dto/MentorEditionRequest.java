package com.lgj.webapp.dto;

import com.lgj.webapp.util.GeneralStatus;

import lombok.Data;

@Data
public class MentorEditionRequest {
  private Long mentorId;
  GeneralStatus status;
}

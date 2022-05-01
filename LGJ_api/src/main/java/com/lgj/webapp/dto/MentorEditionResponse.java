package com.lgj.webapp.dto;

import com.lgj.webapp.util.GeneralStatus;

import lombok.Data;

@Data
public class MentorEditionResponse {
  private Long mentorId;
  private Long editionId;
  private GeneralStatus status;
}

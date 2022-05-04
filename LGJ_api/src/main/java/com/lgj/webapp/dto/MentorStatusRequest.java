package com.lgj.webapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.lgj.webapp.util.GeneralStatus;

import lombok.Data;

@Data
public class MentorStatusRequest {
  @NotBlank
  @NotEmpty
  Long mentorId;
  @NotBlank
  @NotEmpty
  Long editionId;
  @NotBlank
  @NotEmpty
  GeneralStatus status;
}

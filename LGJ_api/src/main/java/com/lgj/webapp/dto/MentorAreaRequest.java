package com.lgj.webapp.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MentorAreaRequest {
  @NotBlank
  @NotEmpty
  private Long mentorId;
  // @NotNull
  // List<AreaMentorRequest> areas;
  // @NotBlank
  // @NotEmpty
  // private Long areaId;
  // @NotNull
  // private Mentor mentor;
  @NotNull
  List<AreaMentorRequest> areas;
}

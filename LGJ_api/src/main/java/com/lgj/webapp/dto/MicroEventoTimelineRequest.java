package com.lgj.webapp.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class MicroEventoTimelineRequest {
  @NotBlank
  @NotEmpty
  private Long edition_id;
  private LocalDate fechaInicio;
}

package com.lgj.webapp.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MentorAvailabilityRequest {
  @NotBlank
  @NotEmpty
  private Long mentorAvailabilityId;
  @NotNull
  @Temporal(TemporalType.TIMESTAMP) //dia mes anio hora
  private Date dateStart;
  @NotNull
  @Temporal(TemporalType.TIMESTAMP) //dia mes anio hora
  private Date dateEnd;
}

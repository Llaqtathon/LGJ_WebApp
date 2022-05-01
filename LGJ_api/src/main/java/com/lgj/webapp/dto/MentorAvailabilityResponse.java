package com.lgj.webapp.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lgj.webapp.entities.MentorEdition;

import lombok.Data;

@Data
public class MentorAvailabilityResponse {
  private Long id;
  @Temporal(TemporalType.TIMESTAMP) //dia mes anio hora
  private Date dateStart;
  @Temporal(TemporalType.TIMESTAMP) //dia mes anio hora
  private Date dateEnd;
  private MentorEdition mentorEdition;
}

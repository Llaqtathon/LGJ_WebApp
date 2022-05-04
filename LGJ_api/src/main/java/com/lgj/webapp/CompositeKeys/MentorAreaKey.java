package com.lgj.webapp.CompositeKeys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
// import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// @Entity
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MentorAreaKey implements Serializable {
  @Column(name = "mentor_id")
  private Long mentorId;
  @Column(name = "area_id")
  private Integer areaId;
}

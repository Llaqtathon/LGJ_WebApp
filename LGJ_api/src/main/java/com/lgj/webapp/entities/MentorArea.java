package com.lgj.webapp.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.lgj.webapp.CompositeKeys.MentorAreaKey;

import lombok.Data;

@Data
@Table (name = "mentor_area")
@Entity
public class MentorArea {
  @EmbeddedId
  MentorAreaKey id;

  @ManyToOne
  @MapsId("mentorId")
  @JoinColumn(name = "mentor_id")
  private Mentor mentor;

  @ManyToOne
  @MapsId("areaId")
  @JoinColumn(name = "area_id")
  private Area area;

  @Column(name = "years_of_experience")
  private Integer yearsOfExperience;
}

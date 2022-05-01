package com.lgj.webapp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.lgj.webapp.CompositeKeys.MentorAreaKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table (name = "mentor_area")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MentorArea {
  @EmbeddedId
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  MentorAreaKey id;

  @ManyToOne(cascade = CascadeType.ALL)
  @MapsId("mentorId")
  @JoinColumn(name = "mentor_id")
  private Mentor mentor;

  @ManyToOne(cascade = CascadeType.ALL)
  @MapsId("areaId")
  @JoinColumn(name = "area_id")
  private Area area;

  @Column(name = "years_of_experience")
  private Integer yearsOfExperience;

  @Column(name = "priority")
  private Integer priority;
  
}

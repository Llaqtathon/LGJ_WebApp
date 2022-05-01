package com.lgj.webapp.entities;

import java.util.List;

import javax.persistence.CascadeType;
// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
// import javax.persistence.FetchType;
// import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
// import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

// import lombok.Data;

// @Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
// @Builder(builderMethodName = "mentorBuilder")
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "mentor_id")
@Table(name = "mentor")
public class Mentor extends User {

  public static MentorBuilder <?,?> toBuilder (User user) {
    return new MentorBuilderImpl().$fillValuesFromUser(user);
  }

  @Column(name = "url_photo", nullable = true, length = 150)
  private String urlPhoto;

  @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "mentor")
  private List<MentorArea> mentors_area;
  @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "mentor")
  private List<MentorEdition> mentors_edition;
}
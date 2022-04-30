package com.lgj.webapp.CompositeKeys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
// import javax.persistence.Entity;

import lombok.Data;

@Data
// @Entity
@Embeddable
public class MentorEditionKey implements Serializable {

  @Column(name = "edition_id")
  private Long editionId;
  @Column(name = "mentor_id")
  private Long mentorId;

}

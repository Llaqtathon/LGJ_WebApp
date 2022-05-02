package com.lgj.webapp.CompositeKeys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MentorEditionKey implements Serializable {

  @Column(name = "edition_id")
  private Long editionId;
  @Column(name = "mentor_id")
  private Long mentorId;

}

package com.lgj.webapp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lgj.webapp.CompositeKeys.MentorEditionKey;
import com.lgj.webapp.util.GeneralStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mentor_edition")
@Entity
public class MentorEdition {
  // Mentores edicion
  // Un usuario puede ser mentor de varias ediciones
  // Una edicion puede tener varios mentores
  // Un mentor no necesariamente tiene que estar inscrito en una edicion como participante
  
  @EmbeddedId
  private MentorEditionKey id;

  @ManyToOne
  @MapsId("mentorId")
  @JoinColumn(name = "mentor_id")
  private Mentor mentor;

  @ManyToOne
  @MapsId("editionId")
  @JoinColumn(name = "edition_id")
  private Edition edition;

  @Column(name = "status")
  @Enumerated(value = EnumType.STRING)
  private GeneralStatus status;

  
  @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "mentorEdition")
  private List<MentorAvailability> availabilities;
}

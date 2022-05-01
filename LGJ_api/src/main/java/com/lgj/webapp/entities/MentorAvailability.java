package com.lgj.webapp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder(toBuilder = true)
@Table(name = "MentorAvailability")
public class MentorAvailability {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumns({
      @JoinColumn(name = "mentor_id", referencedColumnName = "mentor_id"),
      @JoinColumn(name = "edition_id", referencedColumnName = "edition_id")
  })
  private MentorEdition mentorEdition;
  @Column(name = "date_start")
  @Temporal(TemporalType.TIMESTAMP) //dia mes anio hora
  private Date dateStart;
  @Column(name = "date_end")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateEnd;

}
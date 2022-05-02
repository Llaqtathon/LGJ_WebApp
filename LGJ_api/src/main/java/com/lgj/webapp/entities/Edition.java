package com.lgj.webapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "edicion")
public class Edition {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "name")
  private String name;
  @Column (name = "description", nullable = true)
  private String description;
  @Column (name = "date_start_preproduction", nullable = true)
  private Date dateStartPreproduction;
  @Column (name = "date_end_postproduction", nullable = true)
  private Date dateEndPostproduction;
  @Column (name = "date_start", nullable = true)
  private Date dateStart;
  @Column (name = "date_end", nullable = true)
  private Date dateEnd;
  @Column (name = "theme", nullable = true)
  private String theme;
  @Column (name = "space_available")
  private Integer spaceAvailable;
  @ManyToOne
  @JoinColumn(name = "distrito_id")
  private Distrito distrito;
  @Column (name = "location", nullable = true)
  private String location;
  @Column (name = "location_url_gmaps", nullable = true)
  private String locationUrlGmaps;
  @OneToMany(mappedBy = "edition")
  @JsonIgnore // TODO: Create Edition Response DTO and remove JsonIgnore
  private List<Group> groups;
  @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "edition")
  private List<MentorEdition> mentors;

  public Edition addGroup(Group group) {
    groups.add(group);
    return this;
  }
}

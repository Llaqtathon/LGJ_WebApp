package com.lgj.webapp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Edicion")
public class Edition {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (name = "name")
  private String name;
  @Column (name = "description", nullable = true)
  private String description;
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

}
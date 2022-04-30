package com.lgj.webapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

// import lombok.Data;

// @Data
@Entity
@PrimaryKeyJoinColumn(name = "mentor_id")
@Table(name = "mentor")
public class Mentor extends User {
  @Column(name = "url_photo", nullable = true, length = 150)
  private String urlPhoto;
}
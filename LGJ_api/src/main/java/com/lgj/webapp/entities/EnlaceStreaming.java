package com.lgj.webapp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lgj.webapp.util.RedSocialSelection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enlace_streaming")
public class EnlaceStreaming {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @ManyToOne(cascade = CascadeType.ALL)
  private MicroEvento microevento;
  @Column(name = "red_social")
  @Enumerated(value = EnumType.STRING)
  private RedSocialSelection redSocial;
  @Column(name = "url")
  private String url;
}

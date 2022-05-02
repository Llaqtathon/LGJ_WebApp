package com.lgj.webapp.dto;

import java.time.LocalDateTime;

import com.lgj.webapp.util.GeneralStatus;
import com.lgj.webapp.util.TipoMicroEvento;

import lombok.Data;

@Data
public class MicroevntRequest {
  private Long editionId;
  private String name;
  private String nombrePonente;
  private String description;
  private LocalDateTime inicio;
  private LocalDateTime fin;
  private TipoMicroEvento tipo;
  private int cupo;
  private GeneralStatus status;
}

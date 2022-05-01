package com.lgj.webapp.dto;

import java.time.LocalDate;
import java.util.List;

import com.lgj.webapp.entities.EnlaceStreaming;
import com.lgj.webapp.util.GeneralStatus;
import com.lgj.webapp.util.TipoMicroEvento;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MicroEventoOrgResponse {
  private Long id;
  private TipoMicroEvento tipo;
  private GeneralStatus status;
  private LocalDate inicio;
  private LocalDate fin;
  private Boolean imInscripted;
  private String name;
  private String nombrePonente;
  private String description;
  private List<UserOrgShort> asignados;
  private List<EnlaceStreaming> enlaces;
  private Integer cantInscritos;
}

package com.lgj.webapp.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.lgj.webapp.entities.EnlaceStreaming;
import com.lgj.webapp.util.GeneralStatus;
import com.lgj.webapp.util.TipoMicroEvento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MicroEventoOrgResponse {
  private Long id;
  private TipoMicroEvento tipo;
  private GeneralStatus status;
  private LocalDateTime inicio;
  private LocalDateTime fin;
  private Boolean imInscripted;
  private String name;
  private String nombrePonente;
  private String description;
  private List<UserOrgShort> asignados;
  private List<EnlaceStreaming> enlaces;
  private Integer cantInscritos;
}

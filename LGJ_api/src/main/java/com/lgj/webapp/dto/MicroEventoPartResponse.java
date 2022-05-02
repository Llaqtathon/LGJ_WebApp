package com.lgj.webapp.dto;

import java.time.LocalDate;
import java.util.List;

import com.lgj.webapp.entities.EnlaceStreaming;
import com.lgj.webapp.util.TipoMicroEvento;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MicroEventoPartResponse {
  private TipoMicroEvento tipo;
  private LocalDate inicio;
  private LocalDate fin;
  private String name;
  private String nombrePonente;
  private String description;
  private List<EnlaceStreaming> enlaces;
  private Integer cantInscritos;
}

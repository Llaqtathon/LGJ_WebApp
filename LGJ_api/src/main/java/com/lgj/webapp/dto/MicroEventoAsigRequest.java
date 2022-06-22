package com.lgj.webapp.dto;

// import java.time.LocalDate;
// import java.time.LocalDateTime;
import java.util.List;

// import com.lgj.webapp.entities.EnlaceStreaming;
// import com.lgj.webapp.util.GeneralStatus;
// import com.lgj.webapp.util.TipoMicroEvento;

import lombok.Data;

@Data
public class MicroEventoAsigRequest {
  private Long microeventId;
  // private TipoMicroEvento tipo;
  // private GeneralStatus status;
  // private LocalDateTime inicio;
  // private LocalDateTime fin;
  // private String name;
  // private String nombrePonente;
  // private String description;
  // private int cupo;
  private List<Long> asignadosIds;
  // private List<EnlaceStreaming> enlaces;
}

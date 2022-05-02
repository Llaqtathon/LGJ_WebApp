package com.lgj.webapp.dto;

import java.time.LocalDateTime;

import com.lgj.webapp.entities.User;
import com.lgj.webapp.util.GeneralStatus;

import lombok.Data;

@Data
public class InscripcionResponse {
    private Long id;
    private LocalDateTime fecha;
    private String motivo;
    private GeneralStatus status;
    private User users;
    //private  Edicion edicion_id;
}

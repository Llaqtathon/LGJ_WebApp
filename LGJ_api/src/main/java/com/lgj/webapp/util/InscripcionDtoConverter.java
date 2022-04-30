package com.lgj.webapp.util;

import java.util.List;
import java.util.stream.Collectors;

import com.lgj.webapp.dto.InscripcionResponse;
import com.lgj.webapp.entities.Inscripcion;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class InscripcionDtoConverter {
    
   //Inyeccion de dependencia DI
    private ModelMapper modelMapper;

    public  InscripcionDtoConverter(ModelMapper modelMapper) {
      this.modelMapper = modelMapper;
    }

    public InscripcionResponse convertEntityToDto(Inscripcion inscripcion) {
        return modelMapper.map(inscripcion, InscripcionResponse.class);
      }
    
      public List<InscripcionResponse> convertEntityToDto(List<Inscripcion> inscripciones) {
        return inscripciones.stream()
          .map(inscripcion -> convertEntityToDto(inscripcion))
          .collect(Collectors.toList());
      }
}

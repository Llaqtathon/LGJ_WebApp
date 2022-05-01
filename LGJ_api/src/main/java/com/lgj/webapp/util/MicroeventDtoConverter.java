package com.lgj.webapp.util;

import java.util.List;
import java.util.stream.Collectors;

import com.lgj.webapp.dto.MicroEventoOrgResponse;
import com.lgj.webapp.entities.MicroEvento;
import com.lgj.webapp.entities.UserMicroE;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MicroeventDtoConverter {
  
  private ModelMapper modelMapper;

  public MicroeventDtoConverter(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public MicroEventoOrgResponse convertMicroevntToDto(MicroEvento microevent) {
    return modelMapper.map(microevent, MicroEventoOrgResponse.class);
  }
  public List<MicroEventoOrgResponse> convertMentorToDto(List<MicroEvento> microevents) {
    return microevents.stream()
      .map(micro -> convertMicroevntToDto(micro))
      .collect(Collectors.toList());
  }
  public MicroEventoOrgResponse convertMicroevntAsignToDto(UserMicroE microevent) {
    return modelMapper.map(microevent, MicroEventoOrgResponse.class);
  }
  public List<MicroEventoOrgResponse> convertMicroevntAsignToDto(List<UserMicroE> microevents) {
    return microevents.stream()
      .map(micro -> convertMicroevntAsignToDto(micro))
      .collect(Collectors.toList());
  }

}

package com.lgj.webapp.util;

import java.util.List;
import java.util.stream.Collectors;

import com.lgj.webapp.dto.MicroEventoOrgResponse;
import com.lgj.webapp.dto.UserOrgShort;
import com.lgj.webapp.entities.MicroEvento;
import com.lgj.webapp.entities.User;
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
  public List<MicroEventoOrgResponse> convertMicroevntToDto(List<MicroEvento> microevents) {
    return microevents.stream()
      .map(micro -> convertMicroevntToDto(micro))
      .collect(Collectors.toList());
  }

  
  public MicroEventoOrgResponse convertUseMicroToEventDto(UserMicroE microevent) {
    // return modelMapper.map(microevent, MicroEventoOrgResponse.class);
    return MicroEventoOrgResponse.builder()
      .id(microevent.getMicroevento().getId())
      .name(microevent.getMicroevento().getName())
      .inicio(microevent.getMicroevento().getInicio())
      .fin(microevent.getMicroevento().getFin())
      .imInscripted(microevent.getInteresado())
      .tipo(microevent.getMicroevento().getTipo())
      .description(microevent.getMicroevento().getDescription())
      .enlaces(microevent.getMicroevento().getEnlaces())
      .build();
  }
  public List<MicroEventoOrgResponse> convertUseMicroToEventDto(List<UserMicroE> microevents) {
    return microevents.stream()
      .map(micro -> convertUseMicroToEventDto(micro))
      .collect(Collectors.toList());
  }

  public UserOrgShort convertMicroevntAsignToDto(UserMicroE microevent) {
    // return MicroEventoOrgResponse.builder()
    //   .id(microevent.getMicroevento().getId())
    //   .tipo(microevent.getMicroevento().getTipo())
    //   .status(microevent.getMicroevento().getStatus())
    //   .inicio(microevent.getMicroevento().getInicio())
    //   .fin(microevent.getMicroevento().getFin())
    //   .imInscripted(microevent.getInteresado())
    //   .name(microevent.getMicroevento().getName())
    //   .description(microevent.getMicroevento().getDescription())
    //   .build();
    return UserOrgShort.builder()
          .id(microevent.getMicroevento().getId())
          .nombres( microevent.getUser().getNombres()) 
          .apellidos( microevent.getUser().getApellidos()) 
          .build();
    // return modelMapper.map(microevent, UserOrgShort.class);
  }
  public List<UserOrgShort> convertMicroevntAsignToDto(List<UserMicroE> microevents) {
    return microevents.stream()
      .map(micro -> convertMicroevntAsignToDto(micro))
      .collect(Collectors.toList());
  }


}

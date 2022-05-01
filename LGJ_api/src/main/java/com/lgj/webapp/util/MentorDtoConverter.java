package com.lgj.webapp.util;

import java.util.List;
import java.util.stream.Collectors;

import com.lgj.webapp.dto.MentorAreaResponse;
import com.lgj.webapp.dto.MentorAvailabilityResponse;
import com.lgj.webapp.dto.MentorEditionResponse;
import com.lgj.webapp.dto.MentorResponse;
import com.lgj.webapp.dto.OrderResponse;
import com.lgj.webapp.entities.Mentor;
import com.lgj.webapp.entities.MentorArea;
import com.lgj.webapp.entities.MentorAvailability;
import com.lgj.webapp.entities.MentorEdition;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MentorDtoConverter {
  
  private ModelMapper modelMapper;

  public MentorDtoConverter(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }


  public MentorResponse convertMentorToDto(Mentor mentor) {
    return modelMapper.map(mentor, MentorResponse.class);
  }
  public List<MentorResponse> convertMentorToDto(List<Mentor> mentors) {
    return mentors.stream()
      .map(mentor -> convertMentorToDto(mentor))
      .collect(Collectors.toList());
  }
  public MentorEditionResponse convertMentorEditionToMentorDto(MentorEdition mentorEdition) {
    return MentorEditionResponse.builder()
      .mentorId(mentorEdition.getMentor().getId())
      .editionId(mentorEdition.getEdition().getId())
      .nombres(mentorEdition.getMentor().getNombres())
      .apellidos(mentorEdition.getMentor().getApellidos())
      .urlPhoto(mentorEdition.getMentor().getUrlPhoto())
      .status(mentorEdition.getStatus())
      .areas(convertMentorAreaToDto(mentorEdition.getMentor().getAreas()))
      .availabilities(convertMentorAvailabilityToDto(mentorEdition.getAvailabilities()))
      .build();
    // return modelMapper.map(mentorEdition, MentorEditionResponse.class);
  }
  public List<MentorEditionResponse> convertMentorEditionToMentorDto(List<MentorEdition> mentorsEdition) {
    return mentorsEdition.stream()
      .map( mEdition -> convertMentorEditionToMentorDto(mEdition) )
      .collect(Collectors.toList());
  }

  public MentorAreaResponse convertMentorAreaToDto(MentorArea mentorArea) {
    return modelMapper.map(mentorArea, MentorAreaResponse.class);
  }
  public List<MentorAreaResponse> convertMentorAreaToDto(List<MentorArea> mentorAreas) {
    return mentorAreas.stream()
      .map(mentorArea -> convertMentorAreaToDto(mentorArea))
      .collect(Collectors.toList());
  }

  public MentorAvailabilityResponse convertMentorAvailabilityToDto(MentorAvailability mentorAvailability) {
    return modelMapper.map(mentorAvailability, MentorAvailabilityResponse.class);
  }
  public List<MentorAvailabilityResponse> convertMentorAvailabilityToDto(List<MentorAvailability> availabilities) {
    return availabilities.stream()
      .map(availability -> convertMentorAvailabilityToDto(availability))
      .collect(Collectors.toList());
  }

  public MentorEditionResponse convertMentorEditionToDto(MentorEdition mentorEdition) {
    return modelMapper.map(mentorEdition, MentorEditionResponse.class);
  }
}

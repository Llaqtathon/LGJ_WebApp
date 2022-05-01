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
import com.lgj.webapp.entities.Order;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter {

  //Inyeccion de dependencia DI
  private ModelMapper modelMapper;

  public EntityDtoConverter(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public OrderResponse convertEntityToDto(Order order) {
    return modelMapper.map(order, OrderResponse.class);
  }
  public List<OrderResponse> convertEntityToDto(List<Order> orders) {
    return orders.stream()
      .map(order -> convertEntityToDto(order))
      .collect(Collectors.toList());
  }

  public MentorResponse convertMentorToDto(Mentor mentor) {
    return modelMapper.map(mentor, MentorResponse.class);
  }
  public List<MentorResponse> convertMentorToDto(List<Mentor> mentors) {
    return mentors.stream()
      .map(mentor -> convertMentorToDto(mentor))
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

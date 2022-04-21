package com.lgj.webapp.util;

import java.util.List;
import java.util.stream.Collectors;

import com.lgj.webapp.dto.OrderResponse;
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
}

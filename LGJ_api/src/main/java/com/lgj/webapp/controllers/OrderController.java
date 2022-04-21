package com.lgj.webapp.controllers;

import com.lgj.webapp.dto.OrderRequest;
import com.lgj.webapp.dto.OrderResponse;
import com.lgj.webapp.entities.Order;
import com.lgj.webapp.services.OrderService;
import com.lgj.webapp.util.EntityDtoConverter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

  private OrderService orderService;
  private EntityDtoConverter converter;

  public OrderController(OrderService orderService, EntityDtoConverter converter) {
    this.orderService = orderService;
    this.converter = converter;
  }

  //OBS: {variable} tiene que ser === a ...(@PathVariable Tipo variable)
  @GetMapping("/account/{accountId}")
  public ResponseEntity<List<OrderResponse>> findAllOrders(@PathVariable String accountId) {
    List<Order> orders = orderService.getAllOrderByAccountId(accountId);
    return new ResponseEntity<>(converter.convertEntityToDto(orders), HttpStatus.OK);
  }
  
  @GetMapping("/{orderId}")
  public ResponseEntity<OrderResponse> findOrderById(@PathVariable String orderId) {
    Order order = orderService.getOrderById(orderId);
    return new ResponseEntity<>(converter.convertEntityToDto(order), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
    Order order = orderService.createOrder(request);
    return new ResponseEntity<>(converter.convertEntityToDto(order), HttpStatus.CREATED);
  }
}

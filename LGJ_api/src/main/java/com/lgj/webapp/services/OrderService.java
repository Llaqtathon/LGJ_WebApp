package com.lgj.webapp.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.lgj.webapp.dto.OrderRequest;
import com.lgj.webapp.entities.Order;
import com.lgj.webapp.entities.OrderDetail;
import com.lgj.webapp.repository.OrderRepository;
import com.lgj.webapp.util.OrderStatus;
import com.lgj.webapp.util.OrderValidator;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

  private OrderRepository orderRepository;
  public OrderService(OrderRepository repository) {
    this.orderRepository = repository;
  }

  @Transactional(readOnly = true)
  public Order getOrderById(String orderId) {
    return orderRepository.findOrderByOrderId(orderId);
  }

  @Transactional(readOnly = true)
  public List<Order> getAllOrderByAccountId(String accountId) {
    return orderRepository.findOrdersByAccountId(accountId);
  }

  @Transactional
  public Order createOrder(OrderRequest orderRequest) {
    OrderValidator.validateOrder(orderRequest);
    Order orderNew = initOrder(orderRequest);
    return orderRepository.save(orderNew);
  }

  private Order initOrder(OrderRequest orderRequest) {
    Order orderObj = new Order();
    orderObj.setOrderId(UUID.randomUUID().toString());
    orderObj.setAccountId(orderRequest.getAccountId());
    orderObj.setStatus(OrderStatus.PENDING);

    // Detail
    List<OrderDetail> orderDetails = orderRequest.getItems()
        .stream()
        .map(
          item -> OrderDetail.builder()
            .price(item.getPrice())
            .quantity(item.getQuantity())
            .upc(item.getUpc())
            .tax(item.getPrice()*item.getQuantity()*0.16)
            .totalAmount(item.getPrice()*item.getQuantity())
            .order(orderObj)
            .build()
          )
        .collect(java.util.stream.Collectors.toList());

    orderObj.setDetails(orderDetails);
    orderObj.setTotalAmount(orderDetails.stream().mapToDouble(OrderDetail::getTotalAmount).sum());
    orderObj.setTotalTax(orderObj.getTotalAmount() * 0.16);
    orderObj.setTotalAmountTax(orderObj.getTotalAmount() + orderObj.getTotalTax());
    orderObj.setTransactionDate(new Date());
    return orderObj;
  }

}

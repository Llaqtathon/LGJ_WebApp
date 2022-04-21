package com.lgj.webapp.util;

import com.lgj.webapp.dto.OrderRequest;
import com.lgj.webapp.exception.IncorrectOrderRequestException;

public class OrderValidator {
  public static boolean validateOrder(OrderRequest order) {
    if(order.getItems() == null || order.getItems().isEmpty()) {
      throw new IncorrectOrderRequestException("Order detail sin contenido");
    }
    return true;
  }
}

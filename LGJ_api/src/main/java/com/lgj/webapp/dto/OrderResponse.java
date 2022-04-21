package com.lgj.webapp.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderResponse {
  private String orderId;
  private String status;
  private String accountId;
  private Double totalAmount;
  private Double totalTax;
  private Double totalAmountTax;
  private Date transactionDate;
  List<OrderDetailResponse> details;
}
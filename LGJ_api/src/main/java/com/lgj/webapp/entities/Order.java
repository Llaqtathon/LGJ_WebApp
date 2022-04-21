package com.lgj.webapp.entities;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lgj.webapp.util.OrderStatus;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "order_id", nullable = false, length = 50)
  private String orderId;
  @Column(name = "status")
  @Enumerated(value = EnumType.STRING)
  private OrderStatus status;
  @Column(name = "account_id")
  private String accountId;
  @Column(name = "total_amount")
  private Double totalAmount;
  @Column(name = "total_tax")
  private Double totalTax;
  @Column(name = "total_amount_tax")
  private Double totalAmountTax;
  @Column(name = "transaction_date")
  @Temporal(TemporalType.TIMESTAMP) //dia mes anio hora
  private Date transactionDate;

  //fecthType.EAGER = trae todos los datos de la tabla relacionada
  //fetcthType.LAZY = trae solo el id de la tabla relacionada | a pedido
  @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "order")
  private List<OrderDetail> details;
}

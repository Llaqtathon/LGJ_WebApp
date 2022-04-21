package com.lgj.webapp.repository;

import java.util.List;

import com.lgj.webapp.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
  @Query("SELECT o FROM Order o WHERE o.accountId = ?1")//jpql
  List<Order> findOrdersByAccountId(String accountId);

  Order findOrderByOrderId(String orderId);
  
  @Query(value = "SELECT  * FROM orders o WHERE o.order_id = ?1", nativeQuery = true)//sql
  Order findOrderByOrderIdNative(String orderId);
}

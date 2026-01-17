package com.ecom.repository;

import com.ecom.entity.Orders;
import com.ecom.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,String> {


    List<OrderItem> findByOrderId(String orderId);

    List<Orders> findByCustomerId(String customerId);
}

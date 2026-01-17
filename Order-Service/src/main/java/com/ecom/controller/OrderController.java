package com.ecom.controller;

import com.ecom.dto.OrderRequestDto;
import com.ecom.dto.OrderResponseDto;
import com.ecom.dto.OrderStatus;
import com.ecom.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequestDto orderRequestDto){
        OrderResponseDto orderResponseDto = orderService.placeOrder(orderRequestDto);
        return ResponseEntity.ok(orderResponseDto);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable String orderId){
        OrderResponseDto orderResponseDto = orderService.getOrderById(orderId);
        return ResponseEntity.ok(orderResponseDto);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getOrderByCustomerId(@PathVariable String customerId){
        List<OrderResponseDto> orderByCustomerId = orderService.getOrderByCustomerId(customerId);
        return ResponseEntity.ok(orderByCustomerId);
    }

    @PatchMapping("/{orderId}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable String orderId,@RequestParam OrderStatus status){
        orderService.updateOrderStatus(orderId,status);
        return ResponseEntity.ok("Order status update to " + status.name());
    }
}

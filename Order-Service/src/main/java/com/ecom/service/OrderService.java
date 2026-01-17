package com.ecom.service;

import com.ecom.dto.*;
import com.ecom.entity.Order;
import com.ecom.entity.OrderItem;
import com.ecom.repository.OrderItemRepository;
import com.ecom.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductClient productClient;

    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto){

        //Generate OrderId
        String orderId = generateOrderId();
        double totalAmount = 0.0;

        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemRequest itemRequest : orderRequestDto.getItems()){
            ProductResponseDto productName = productClient.getProductName(itemRequest.getProductId());
            //validate the product
            if (productName.getStockQuantity()<itemRequest.getQuantity()){
                throw new RuntimeException("insufficient stock for product : " + productName.getName());
            }
            //update stock
            productClient.updateStock(itemRequest.getProductId(),-itemRequest.getQuantity());
            double itemTotal = itemRequest.getQuantity() * productName.getPrice();
            totalAmount=totalAmount+itemTotal;

            OrderItem orderItem = new OrderItem(generateOrderItemsId(),orderId,itemRequest.getProductId()
                    ,itemRequest.getQuantity(),productName.getPrice());

            orderItems.add(orderItem);
        }

        Order order = new Order(orderId,orderRequestDto.getCustomerId(),
                LocalDateTime.now(),totalAmount,OrderStatus.PENDING);

        orderRepository.save(order);
        orderItemRepository.saveAll(orderItems);

        return new OrderResponseDto(order.getOrderId(),order.getCustomerId(),
                order.getOrderDate(),order.getTotalAmount(),order.getStatus(),orderItems);
    }

    public OrderResponseDto getOrderById(String orderId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id : " + orderId));

        List<OrderItem> items = orderRepository.findByOrderId(orderId);
        return new OrderResponseDto(order.getOrderId(),order.getCustomerId(),order.getOrderDate(),
                order.getTotalAmount(),order.getStatus(),items);
    }

    public List<OrderResponseDto> getOrderByCustomerId(String customerId){
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        List<OrderResponseDto> responseList = new ArrayList<>();

        for (Order order : orders){
            List<OrderItem> items=orderItemRepository.findByOrderId(order.getOrderId());
            responseList.add(new OrderResponseDto(order.getOrderId(),order.getCustomerId(),
                    order.getOrderDate(),order.getTotalAmount(),order.getStatus(),items));
        }
        return responseList;
    }

    private String generateOrderId(){
        return "ord-" + UUID.randomUUID().toString().substring(0,8);
    }

    private String generateOrderItemsId(){
        return "item-" + UUID.randomUUID().toString().substring(0,8);
    }
}

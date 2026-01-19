package com.ecom.service;

import com.ecom.dto.OrderStatusRequestDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderClient {

    private final RestTemplate restTemplate;

    public OrderClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public void updateOrderStatus(String orderId,String staus){
        String url = "http://localhost:8082/orders/" + orderId + "/status?status=" + staus;
        OrderStatusRequestDto request = new OrderStatusRequestDto(orderId,staus);
        String response = restTemplate.patchForObject(url, request, String.class);
        System.out.println("Order status update : " + response);
    }

}

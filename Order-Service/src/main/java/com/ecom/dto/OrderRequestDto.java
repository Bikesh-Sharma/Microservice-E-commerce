package com.ecom.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {
    private String customerId;
    private List<OrderItemRequest> items;

}

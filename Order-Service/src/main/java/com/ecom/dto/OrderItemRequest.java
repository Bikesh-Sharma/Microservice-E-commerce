package com.ecom.dto;

import lombok.Data;

@Data
public class OrderItemRequest {
    private String productId;
    private int quantity;

}

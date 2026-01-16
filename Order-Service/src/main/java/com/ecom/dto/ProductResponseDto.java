package com.ecom.dto;

import lombok.Data;

@Data
public class ProductResponseDto {
    private String productId;
    private String name;
    private Double price;
    private Integer stockQuantity;
}

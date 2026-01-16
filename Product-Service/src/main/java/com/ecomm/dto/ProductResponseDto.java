package com.ecomm.dto;

import com.ecomm.entity.Category;
import lombok.Data;

@Data
public class ProductResponseDto {

    private String productId;
    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
    private Boolean inStock;
    private String categoryName;
}

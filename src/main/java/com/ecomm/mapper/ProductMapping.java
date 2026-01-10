package com.ecomm.mapper;

import com.ecomm.dto.ProductResponseDto;
import com.ecomm.entity.Product;

public class ProductMapping {

    public static ProductResponseDto toProductResponseDto(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setProductId(product.getProductId());
        productResponseDto.setName(product.getName());
        productResponseDto.setCategoryName(product.getCategory().getName());
        productResponseDto.setStockQuantity(product.getStockQuantity());
        productResponseDto.setInStock(product.getInStock());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setDescription(product.getDescription());
        return productResponseDto;
    }

    public static Product toProductEntity(ProductResponseDto productResponseDto){
        Product product = new Product();
        product.setProductId(productResponseDto.getProductId());
        product.setName(productResponseDto.getName());
        product.setPrice(productResponseDto.getPrice());
        product.setInStock(productResponseDto.getInStock());
        product.setDescription(productResponseDto.getDescription());
        product.setStockQuantity(productResponseDto.getStockQuantity());
        return product;
    }
}

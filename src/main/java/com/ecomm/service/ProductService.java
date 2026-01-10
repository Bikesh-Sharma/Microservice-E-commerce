package com.ecomm.service;

import com.ecomm.dto.ProductRequestDto;
import com.ecomm.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);
    ProductResponseDto getProductById(String productId);
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto updateProduct(String productId,Integer stockQuantity);
}

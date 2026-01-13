package com.ecomm.controller;

import com.ecomm.dto.ProductRequestDto;
import com.ecomm.dto.ProductResponseDto;
import com.ecomm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductResponseDto createProducts(@RequestBody ProductRequestDto productRequestDto){
        return productService.createProduct(productRequestDto);
    }
    @GetMapping("/{productId}")
    public ProductResponseDto getProductByid(@PathVariable String productId){
        return productService.getProductById(productId);
    }
    @GetMapping
    public List<ProductResponseDto> getAllProducts(){
        return productService.getAllProducts();
    }
    @PatchMapping("/{productId}/stock")
    public ProductResponseDto updateStock(@PathVariable String productId,@RequestParam Integer stockQuantity){
        return productService.updateProduct(productId,stockQuantity);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable String productId){
        return productService.deleteProduct(productId);
    }
}

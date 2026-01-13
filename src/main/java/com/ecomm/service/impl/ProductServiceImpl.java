package com.ecomm.service.impl;

import com.ecomm.dto.ProductRequestDto;
import com.ecomm.dto.ProductResponseDto;
import com.ecomm.entity.Category;
import com.ecomm.entity.Product;
import com.ecomm.repository.CategoryRepository;
import com.ecomm.repository.ProductRepository;
import com.ecomm.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Category category = categoryRepository.findById(productRequestDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Product product = new Product();
        product.setName(productRequestDto.getName());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setStockQuantity(productRequestDto.getStockQuantity());
        product.setCategory(category);
        Product saveProduct = productRepository.save(product);
        ProductResponseDto productResponseDto = convertToDto(saveProduct);
        return productResponseDto;
    }

    @Override
    public ProductResponseDto getProductById(String productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        ProductResponseDto productResponseDto = convertToDto(product);
        return productResponseDto;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll()
                .stream().map(this::convertToDto).toList();
    }

    @Override
    public ProductResponseDto updateProduct(String productId, Integer stockQuantity){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setStockQuantity(stockQuantity);
        productRepository.save(product);
        ProductResponseDto productResponseDto = convertToDto(product);
        return productResponseDto;
    }

public String deleteProduct(String productId){
    Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Produce not found"));
    productRepository.delete(product);
    return "Product" + productId + " deleted successfully ";
    }

    private ProductResponseDto convertToDto(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setProductId(product.getProductId());
        productResponseDto.setName(product.getName());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setInStock(product.getInStock());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStockQuantity(product.getStockQuantity());
        productResponseDto.setCategoryName(product.getCategory().getName());
        return productResponseDto;
    }
}

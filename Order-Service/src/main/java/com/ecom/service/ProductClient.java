package com.ecom.service;

import com.ecom.dto.ProductResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductClient {

    private RestTemplate restTemplate;

    public ProductClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public ProductResponseDto getProductName(String productId){
        String url = "http://localhost:8081/products/" + productId;
        return restTemplate.getForObject(url,ProductResponseDto.class);
    }

    public void updateStock(String productId,int quantity){
        String url="http://localhost:8081/products/" + productId + "/stock?stockQuantity=" + quantity;
        restTemplate.patchForObject(url,null,Void.class);
    }
}

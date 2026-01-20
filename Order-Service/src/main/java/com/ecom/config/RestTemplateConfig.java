package com.ecom.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory =
                new HttpComponentsClientHttpRequestFactory();
        return new RestTemplate(factory);
    }
}

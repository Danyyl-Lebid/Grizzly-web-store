package com.github.grizzly.service.impl;

import com.github.grizzly.repository.ProductRepository;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@TestConfiguration
@ComponentScan(basePackages = {
        "com.github.grizzly.repository",
        "com.github.grizzly.service.impl"
})
public class ProductServiceTestConfiguration {

    @Bean
    public ProductRepository productRepository(){
        return Mockito.mock(ProductRepository.class);
    }

    @Bean
    public ProductService productService(){
        return new ProductService(productRepository());
    }

}

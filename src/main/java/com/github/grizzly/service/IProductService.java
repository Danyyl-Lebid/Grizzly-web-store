package com.github.grizzly.service;

import com.github.grizzly.dto.ProductDto;
import com.github.grizzly.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> readAll();

    Product create(ProductDto productDto);

    Optional<Product> readByName(String name);

    void update(Product product);

    void deleteById(Long id);

}

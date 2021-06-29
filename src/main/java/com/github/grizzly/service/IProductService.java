package com.github.grizzly.service;

import com.github.grizzly.dto.ProductDto;
import com.github.grizzly.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> readAll();

    Product create(ProductDto productDto);

    void update(Product product);

    void deleteById(Long id);

}

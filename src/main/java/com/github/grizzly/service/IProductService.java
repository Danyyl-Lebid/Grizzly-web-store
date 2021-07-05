package com.github.grizzly.service;

import com.github.grizzly.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Optional<Product> readById(Long id);

    Optional<Product> readByName(String name);

    List<Product> readAll();

    Product create(Product product);

    void update(Product product);

    Optional<Product> deleteById(Long id);

}

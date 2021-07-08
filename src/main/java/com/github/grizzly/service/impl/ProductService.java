package com.github.grizzly.service.impl;

import com.github.grizzly.entity.ActiveState;
import com.github.grizzly.entity.Product;
import com.github.grizzly.repository.ProductRepository;
import com.github.grizzly.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public Optional<Product> readById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Optional<Product> readByName(String name) {
        return this.productRepository.findByName(name);
    }

    @Override
    public List<Product> readAll() {
        return this.productRepository.findAll();
    }

    @Override
    public List<Product> readAllProductByStatus(ActiveState activeState) {
        return this.productRepository.findProductsByState(activeState);
    }

    @Override
    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public Optional<Product> deleteById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        product.get().setState(ActiveState.OFF);
        return productRepository.findById(id);
    }
}

package com.github.grizzly.service.impl;

import com.github.grizzly.dto.ProductDto;
import com.github.grizzly.entity.Product;
import com.github.grizzly.repository.ProductRepository;
import com.github.grizzly.service.IProductService;
import com.github.grizzly.utils.TransferObj;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> readAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product create(ProductDto productDto) {
        Product product = TransferObj.toProduct(productDto);
        return this.productRepository.save(product);
    }

    @Override
    public Optional<Product> readByName(String name) {
        return this.productRepository.findByName(name);
    }

    @Override
    public void update(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}

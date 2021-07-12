package com.github.grizzly.service.impl;

import com.github.grizzly.dto.ProductDto;
import com.github.grizzly.entity.ActiveState;
import com.github.grizzly.entity.Category;
import com.github.grizzly.entity.Product;
import com.github.grizzly.repository.CategoryRepository;
import com.github.grizzly.repository.ProductRepository;
import com.github.grizzly.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void update(Long id, Product newProduct) {
        Product product = productRepository.getById(id);
        product.setName(newProduct.getName());
        product.setDescription(newProduct.getDescription());
        product.setMainImage(newProduct.getMainImage());
        product.setPrice(newProduct.getPrice());
        product.setQuantity(newProduct.getQuantity());
        product.setCategory(newProduct.getCategory());
        this.productRepository.save(newProduct);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productRepository.updateState(id, ActiveState.OFF);
    }
}

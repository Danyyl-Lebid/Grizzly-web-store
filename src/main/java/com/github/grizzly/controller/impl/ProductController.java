package com.github.grizzly.controller.impl;

import com.github.grizzly.controller.IProductController;
import com.github.grizzly.dto.ProductDto;
import com.github.grizzly.entity.Category;
import com.github.grizzly.entity.Product;
import com.github.grizzly.exceptions.EntityNotFoundException;
import com.github.grizzly.repository.ProductRepository;
import com.github.grizzly.service.ICategoryService;
import com.github.grizzly.service.IProductService;
import com.github.grizzly.utils.ProductTransferObj;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.github.grizzly.utils.ProductTransferObj.fromProduct;
import static com.github.grizzly.utils.ProductTransferObj.toProduct;

@RestController
@RequiredArgsConstructor
public class ProductController implements IProductController {

    private final IProductService productService;

    private final ICategoryService categoryService;

    @Override
    @GetMapping("/products")
    public List<ProductDto> findAll() {
        return this.productService.readAll().stream()
                .map(ProductTransferObj::fromProduct)
                .collect(Collectors.toList());
    }

    @Override
    @PostMapping("/product/add")
    public ProductDto save(ProductDto payload) {
        Long id = payload.getId();
        Category category = this.categoryService.findCategoryById(id).orElseThrow(EntityNotFoundException::new);
        Product product = toProduct(payload, category);
        product.setCategory(category);
        return fromProduct(this.productService.create(product));

    }

    @Override
    @PutMapping("/product/edit")
    public void update(ProductDto payload) {
        Long id = payload.getId();
        Category category = this.categoryService.findCategoryById(id).orElseThrow(EntityNotFoundException::new);
        Product product = toProduct(payload, category);
        this.productService.update(product);
    }

    @Override
    public void deleteProductById(Long id) {
        this.productService.deleteById(id);
    }
}

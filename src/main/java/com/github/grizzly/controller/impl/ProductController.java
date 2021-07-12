package com.github.grizzly.controller.impl;

import com.github.grizzly.controller.IProductController;
import com.github.grizzly.dto.ProductDto;
import com.github.grizzly.entity.ActiveState;
import com.github.grizzly.entity.Category;
import com.github.grizzly.entity.Product;
import com.github.grizzly.exceptions.EntityNotFoundException;
import com.github.grizzly.service.ICategoryService;
import com.github.grizzly.service.IProductService;
import com.github.grizzly.utils.ProductTransferObj;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.grizzly.utils.ProductTransferObj.fromProduct;
import static com.github.grizzly.utils.ProductTransferObj.toProduct;

@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
public class ProductController implements IProductController {

    private final IProductService productService;

    private final ICategoryService categoryService;

    @Override
    public List<ProductDto> findAll() {
        return this.productService.readAll().stream()
                .map(ProductTransferObj::fromProduct)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findAllProductByStatus(ActiveState activeState) {
        return this.productService.readAllProductByStatus(activeState)
                .stream()
                .map(ProductTransferObj::fromProduct)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto save(ProductDto payload) {
        Long id = payload.getId();
        Category category = this.categoryService.findCategoryById(id).orElseThrow(EntityNotFoundException::new);
        Product product = toProduct(payload, category);
        product.setCategory(category);
        return fromProduct(this.productService.create(product));
    }

    @Override
    public void update(ProductDto payload) {
        Long id = payload.getCategoryId();
        Category category = this.categoryService.findCategoryById(id).orElseThrow(EntityNotFoundException::new);
        Product product = toProduct(payload, category);
        this.productService.update(id, product);
    }

    @Override
    public void deleteProductById(Long id) {
        this.productService.deleteById(id);
    }
}

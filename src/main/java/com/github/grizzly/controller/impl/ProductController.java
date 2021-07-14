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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.grizzly.utils.ProductTransferObj.*;

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
    @Transactional
    public ProductDto save(ProductDto payload) {
        String name = payload.getCategoryName();
        Category category = this.categoryService.findCategoryByName(name).orElseThrow(EntityNotFoundException::new);
        Product product = toProduct(payload, category);
        return fromProduct(this.productService.create(product));
    }

    @Override
    public void update(ProductDto payload) {
        this.productService.update(toProductWithoutCategory(payload));
    }

    @Override
    public void deleteProductById(Long id) {
        this.productService.deleteById(id);
    }
}

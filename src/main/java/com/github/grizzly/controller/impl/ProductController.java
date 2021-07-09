package com.github.grizzly.controller.impl;

import com.github.grizzly.controller.IProductController;
import com.github.grizzly.dto.ProductDto;
import com.github.grizzly.service.IProductService;
import com.github.grizzly.utils.ProductTransferObj;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.grizzly.utils.ProductTransferObj.fromProduct;
import static com.github.grizzly.utils.ProductTransferObj.toProduct;

@RestController
@RequiredArgsConstructor
public class ProductController implements IProductController {

    private final IProductService productService;

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
        return fromProduct(this.productService.create(toProduct(payload)));
    }

    @Override
    @PutMapping("/product/edit")
    public void update(ProductDto payload) {
        this.productService.update(toProduct(payload));
    }

    @Override
    public void deleteProductById(Long id) {
        this.productService.deleteById(id);
    }
}

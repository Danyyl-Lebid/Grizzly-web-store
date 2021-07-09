package com.github.grizzly.utils;

import com.github.grizzly.dto.ProductDto;
import com.github.grizzly.entity.Product;

public class ProductTransferObj {

    public static Product toProduct(ProductDto data) {
        return new Product(
                data.getName(),
                data.getDescription(),
                data.getMainImage(),
                data.getPrice(),
                data.getQuantity(),
                CategoryTransferObject.toCategory(data.getCategory())
        );
    }

    public static ProductDto fromProduct(Product data) {
        return new ProductDto(
                data.getId(),
                data.getName(),
                data.getDescription(),
                data.getMainImage(),
                data.getPrice(),
                data.getQuantity(),
                CategoryTransferObject.fromCategory(data.getCategory())
        );
    }
}

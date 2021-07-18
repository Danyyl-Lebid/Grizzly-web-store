package com.github.grizzly.utils;

import com.github.grizzly.dto.ProductDto;
import com.github.grizzly.entity.Category;
import com.github.grizzly.entity.Product;

public class ProductTransferObj {

    public static Product toProduct(ProductDto data, Category category) {
        return new Product(
                data.getName(),
                data.getDescription(),
                data.getMainImage(),
                data.getPrice(),
                data.getQuantity()
        ).addCategory(category);
    }

    public static Product toProductWithoutCategory (ProductDto data) {
        return new Product(
                data.getId(),
                data.getName(),
                data.getDescription(),
                data.getMainImage(),
                data.getPrice(),
                data.getQuantity()
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
                data.getCategory().getName()
        );
    }
}

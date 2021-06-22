package com.github.grizzly.repository;

import com.github.grizzly.entity.Category;
import com.github.grizzly.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductRepositoryMock {

    public static Category category1() {
        return new Category(1L,
                null,
                "category1_name",
                "category1_description"
        );
    }

    public static Category category2() {
        return new Category(2L,
                null,
                "category2_name",
                "category2_description"
        );
    }

    public static Category category3() {
        return new Category(3L,
                null,
                "category3_name",
                "category3_description"
        );
    }

    public static Category category4() {
        return new Category(4L,
                null,
                "category4_name",
                "category4_description"
        );
    }

    public static Product product1() {
        return new Product(1L,
                "product1_name",
                "product1_description",
                new BigDecimal("11.99"),
                11,
                category1()
        );
    }

    public static Product product2() {
        return new Product(2L,
                "product2_name",
                "product2_description",
                new BigDecimal("12.99"),
                12,
                category2()
        );
    }

    public static Product product3() {
        return new Product(3L,
                "product3_name",
                "product3_description",
                new BigDecimal("13.99"),
                13,
                category3()
        );
    }

    public static Product product4() {
        return new Product(4L,
                "product4_name",
                "product4_description",
                new BigDecimal("14.99"),
                14,
                category4()
        );
    }

    public static List<Product> products() {
        return List.of(
                product1(),
                product2(),
                product3(),
                product4()
        );
    }

    public static List<Product> productsByCategoryByIdTwo() {
        return List.of(
                product2()
        );
    }

    public static List<Product> productsByCategoryByNameOne() {
        return List.of(
                product1()
        );
    }
}

package com.github.grizzly.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "description")
    private Float price;

    @Column(name = "quantity")
    private int quantity;

    public Product(Long categoryId, String name, String description, Float price, int quantity) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
}

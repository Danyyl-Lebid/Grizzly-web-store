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

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "description")
    private Float price;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

    public Product(String name, String description, Float price, int quantity, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
}

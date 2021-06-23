package com.github.grizzly.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(64)", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "VARCHAR(256)", nullable = false)
    private String description;

    @Column(name = "image", nullable = false)
    private String mainImage;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    private List<String> images = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = CascadeType.ALL)
    private Set<SpecificationValue> specificationValues = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Promotion> promotions = new HashSet<>();

    public Product(
            String name,
            String description,
            String mainImage,
            BigDecimal price,
            int quantity,
            Category category
    ) {
        this.name = name;
        this.description = description;
        this.mainImage = mainImage;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Product(
            Long id,
            String name,
            String description,
            String mainImage,
            BigDecimal price,
            int quantity,
            Category category
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.mainImage = mainImage;
        this.price = price;
        this.quantity = quantity;
        this.category = category;

    }

}
package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", columnDefinition = "VARCHAR(64)")
    private String name;

    @NotNull
    @Column(name = "description", columnDefinition = "VARCHAR(256)")
    private String description;

    @NotNull
    @Column(name = "image")
    private String mainImage;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    @NotNull
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_name", referencedColumnName = "name")
    private Category category;

    @NotNull
    @Column(name = "state", columnDefinition = "VARCHAR(32)")
    @Enumerated(EnumType.STRING)
    private ActiveState state = ActiveState.ON;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    private List<String> images = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<SpecificationValue> specificationValues = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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

    public Product(Long id, String name, String description, String mainImage, BigDecimal price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.mainImage = mainImage;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, String description, String mainImage, BigDecimal price, int quantity) {
        this.name = name;
        this.description = description;
        this.mainImage = mainImage;
        this.price = price;
        this.quantity = quantity;
    }

    public Product addCategory (Category category){
        this.category = category;
        category.addProduct(this);
        return this;
    }
}
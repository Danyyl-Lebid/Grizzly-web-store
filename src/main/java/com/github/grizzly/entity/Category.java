package com.github.grizzly.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "category")
@NoArgsConstructor
public class Category {

    @Id
    @Setter(value = AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "VARCHAR(32)")
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "VARCHAR(256)")
    private String description;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Product> products = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Specification> specifications = new HashSet<>();

    public Category(Long parentId, String name, String description) {
        this.parentId = parentId;
        this.name = name;
        this.description = description;
    }

    public Category(long id, Long parentId, String name, String description) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.description = description;
    }
}

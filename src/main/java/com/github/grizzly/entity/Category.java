package com.github.grizzly.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "category")
@NoArgsConstructor
public class Category {

    @Id
    @Setter(value= AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "parent_id")
    private long parentId;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(32)")
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "VARCHAR(256)")
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Specification> specifications = new HashSet<>();

    public Category(long parentId, String name, String description) {
        this.parentId = parentId;
        this.name = name;
        this.description = description;
    }

    public Category(long id, long parentId, String name, String description) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.description = description;
    }
}

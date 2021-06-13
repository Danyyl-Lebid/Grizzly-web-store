package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.*;

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

    @Column(name = "parent_id", nullable = false)
    private long parentId;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(32)")
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "VARCHAR(256)")
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

    public Category(long parentId, String name, String description) {
        this.parentId = parentId;
        this.name = name;
        this.description = description;
    }
}

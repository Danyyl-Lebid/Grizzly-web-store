package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode
@Data
@Entity
@Table(name = "category")
@NoArgsConstructor
public class Category {

    @Id
    @Setter(value= AccessLevel.NONE)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT(20)")
    private long id;

    @NotNull
    @Column(name = "parent_id", nullable = false, columnDefinition = "BIGINT(20)")
    private long parentId;

    @NotNull
    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(32)")
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "VARCHAR(256)")
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products;

    public Category(long parentId, String name, String description) {
        this.parentId = parentId;
        this.name = name;
        this.description = description;
    }
}

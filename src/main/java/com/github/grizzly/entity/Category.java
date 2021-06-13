package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "category")
@NoArgsConstructor
public class Category {

    @Id
    @Setter(value= AccessLevel.NONE)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT(20)")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @NotNull
    @Column(name = "parent", nullable = false, columnDefinition = "BIGINT(20)")
    private long idParent;

    @NotNull
    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(32)")
    private String name;

    @NotNull
    @Column(name = "description", columnDefinition = "VARCHAR(128)")
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id && idParent == category.idParent && Objects.equals(name, category.name) && Objects.equals(description, category.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idParent, name, description);
    }

    public Category(long id, long idParent, String name, String description) {
        this.id = id;
        this.idParent = idParent;
        this.name = name;
        this.description = description;
    }
}

package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@EqualsAndHashCode
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

    public Category(long idParent, String name, String description) {
        this.idParent = idParent;
        this.name = name;
        this.description = description;
    }
}

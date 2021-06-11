package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subcategory")
@NoArgsConstructor
public class Subcategory {

    @Id
    @Setter(value= AccessLevel.NONE)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT(20)")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id ;

    @NotNull
    @Column(name = "parent_category", nullable = false, columnDefinition = "VARCHAR(32)")
    private String parentCategory;

    @NotNull
    @Column(name = "name_subcategory", nullable = false, columnDefinition = "VARCHAR(32)")
    private String nameSubcategory;

    public Subcategory(long id, String parentCategory, String nameSubcategory) {
        this.id = id;
        this.parentCategory = parentCategory;
        this.nameSubcategory = nameSubcategory;
    }
}

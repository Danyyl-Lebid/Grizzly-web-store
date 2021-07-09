package com.github.grizzly.dto;

import com.github.grizzly.entity.ActiveState;
import com.github.grizzly.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;

    private String name;

    private String description;

    private String mainImage;

    private BigDecimal price;

    private int quantity;

    private CategoryDto category;

}

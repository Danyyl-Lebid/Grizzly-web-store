package com.github.grizzly.utils;

import com.github.grizzly.dto.CategoryDto;
import com.github.grizzly.entity.Category;

public class CategoryTransferObject {

    public static Category toCategory(CategoryDto categoryDto){
        return new Category(
          categoryDto.getParentId(),
          categoryDto.getName(),
          categoryDto.getDescription()
        );
    }

    public static CategoryDto fromCategory(Category category){
        return new CategoryDto(
                category.getParentId(),
                category.getName(),
                category.getDescription()
        );
    }

}
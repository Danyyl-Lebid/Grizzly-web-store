package com.github.grizzly.service.impl;

import com.github.grizzly.entity.Category;
import com.github.grizzly.repository.CategoryRepository;
import com.github.grizzly.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category findCategoryById(long id) {
        return categoryRepository.findCategoryById(id);
    }

    @Override
    public List<Category> findCategoriesByParentId(Long parentId) {
        return categoryRepository.findCategoriesByParentId(parentId);
    }

    @Override
    public List<Category> findCategoriesByParentIdIsNull() {
        return categoryRepository.findCategoriesByParentIdIsNull(null);
    }

    @Override
    public void save(Category category) {
      categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return null;
    }
}

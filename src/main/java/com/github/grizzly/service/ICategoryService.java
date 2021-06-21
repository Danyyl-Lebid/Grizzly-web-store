package com.github.grizzly.service;

import com.github.grizzly.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {

    Category findCategoryById(long id);

    List<Category> findCategoriesByParentId(Long parentId);

    List<Category> findCategoriesByParentIdIsNull();

    void save(Category category);

    Category update(Category category);

}

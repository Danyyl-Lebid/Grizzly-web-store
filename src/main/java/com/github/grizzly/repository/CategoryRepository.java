package com.github.grizzly.repository;

import com.github.grizzly.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryById(long id);

    Category findCategoryByName(String name);

    @Override
    List<Category> findAll();

    List<Category> findAllByParentId();

}

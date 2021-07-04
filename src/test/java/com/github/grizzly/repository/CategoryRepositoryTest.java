package com.github.grizzly.repository;

import com.github.grizzly.entity.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Sql({"grizzly-category-schema.sql", "grizzly-category-data.sql"})
    public void findByIdTest(){
        Category exp = CategoryRepositoryMock.category1();
        Category act = this.categoryRepository.findCategoryById(1L).orElseThrow();
        Assert.assertEquals(exp, act);
    }

    @Test
    @Sql({"grizzly-category-schema.sql", "grizzly-category-data.sql"})
    public void findAll(){
        List<Category> exp = CategoryRepositoryMock.categories();
        List<Category> act = this.categoryRepository.findAll();
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql({"grizzly-category-schema.sql", "grizzly-category-data.sql"})
    public void findAllByParentId(){
        List<Category> exp = List.of(CategoryRepositoryMock.category3());
        List<Category> act = this.categoryRepository.findCategoriesByParentId(1);
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql({"grizzly-category-schema.sql", "grizzly-category-data.sql"})
    public void find(){
        List<Category> exp = List.of(CategoryRepositoryMock.category3());
        List<Category> act = this.categoryRepository.findCategoriesByParentId(1);
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql({"grizzly-category-schema.sql", "grizzly-category-data.sql"})
    public void findCategoryById(){
        Category exp = CategoryRepositoryMock.category1();
        Category act = this.categoryRepository.findCategoryById(1L).orElseThrow();
        Assert.assertEquals(exp, act);
    }

    @Test
    @Sql({"grizzly-category-schema.sql", "grizzly-category-data.sql"})
    public void findCategoriesByParentsIdIsNull(){
        List<Category> exp = List.of(
                CategoryRepositoryMock.category1(),
                CategoryRepositoryMock.category2(),
                CategoryRepositoryMock.category4()
        );
        List<Category> act = this.categoryRepository.findCategoriesByParentIdIsNull();
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }
}
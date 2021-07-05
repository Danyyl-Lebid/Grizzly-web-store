package com.github.grizzly.service.impl;

import com.github.grizzly.entity.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.github.grizzly.service.impl.ProductServiceTestMock.*;
import static org.hamcrest.Matchers.containsInAnyOrder;

@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
@ContextConfiguration(classes = {ProductService.class})
@EnableJpaRepositories(basePackages = "com.github.grizzly.repository")
@EntityScan(basePackages = "com.github.grizzly.entity")
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    @Sql(value = {"grizzly-schema-product.sql", "grizzly-product-data.sql"})
    public void findByName() {
        Product act = product1();
        System.out.println(act);
        Product exp = productService.readByName("product1_name").orElseThrow();
        Assert.assertEquals(exp, act);
    }

    @Test
    @Sql(value = {"grizzly-schema-product.sql", "grizzly-product-data.sql"})
    public void shouldReadAllProducts() {
        List<Product> exp = products();
        List<Product> act = this.productService.readAll();
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql(value = {"grizzly-schema-product.sql", "grizzly-product-data.sql"})
    public void findById() {
        Product act = product2();
        Product exp = this.productService.readById(2L).orElseThrow();
        Assert.assertEquals(exp, act);
    }

    @Test
    @Sql(value = {"grizzly-schema-product.sql", "grizzly-product-data.sql"})
    public void shouldDeleteProductById() {
        Product act = product5();
        Product exp = this.productService.deleteById(5L).orElseThrow();
        Assert.assertEquals(exp, act);
    }

}
package com.github.grizzly.repository;

import com.github.grizzly.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Sql(value = {"grizzly-schema-product.sql", "grizzly-product-data.sql"})
    public void findAllProduct(){
        List<Product> act = this.productRepository.findAllByCategoryId(1);
        System.out.println(act);
    }

}
package com.github.grizzly.service.impl;

import com.github.grizzly.entity.Product;
import com.github.grizzly.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

@RunWith(SpringRunner.class)
//@Import(ProductServiceTestConfiguration.class)
@SpringBootTest
public class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Before
    public void setUp() {
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(ProductServiceTestMock.product1()));
        Mockito.when(productRepository.findById(2L)).thenReturn(Optional.of(ProductServiceTestMock.product2()));
        Mockito.when(productRepository.findById(3L)).thenReturn(Optional.of(ProductServiceTestMock.product3()));
        Mockito.when(productRepository.findById(4L)).thenReturn(Optional.of(ProductServiceTestMock.product4()));
        Mockito.when(productRepository.findAll()).thenReturn(ProductServiceTestMock.products());
    }

    @Test
    public void findAll() {
        List<Product> exp = ProductServiceTestMock.products();
        List<Product> act = productService.readAll();
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

}
package com.github.grizzly.controller.impl;

import com.github.grizzly.dto.ProductDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@RunWith(SpringRunner.class)
public class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String localhost = "http://localhost:";

    private String upl;

    @Before
    public void setUp() throws Exception {
        this.upl = String.format("%s%d%s", this.localhost, this.port, "/products");
    }

    @Test
    public void shouldFindAllProducts() throws URISyntaxException {
        ResponseEntity<ProductDto> result = this.testRestTemplate.exchange(
                new URI(this.upl), HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                }
        );
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
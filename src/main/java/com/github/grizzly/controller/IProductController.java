package com.github.grizzly.controller;

import com.github.grizzly.dto.ProductDto;
import com.github.grizzly.entity.ActiveState;
import com.github.grizzly.enums.Status;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IProductController {

    @GetMapping(path = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductDto> findAll();

    @GetMapping(path = "/find-all-{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductDto> findAllProductByStatus(@PathVariable("status") ActiveState activeState);

    @PostMapping(path = "/add-new", produces = MediaType.APPLICATION_JSON_VALUE)
    ProductDto save(@RequestBody ProductDto payload);

    @PutMapping(path = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody ProductDto payload);

    @DeleteMapping(path = "/delete-{id}")
    void deleteProductById(@PathVariable(name = "id") Long id);

}

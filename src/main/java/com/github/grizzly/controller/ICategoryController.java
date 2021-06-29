package com.github.grizzly.controller;

import com.github.grizzly.dto.ProductDto;
import com.github.grizzly.entity.Category;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ICategoryController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Category> findAll();

    @PutMapping
    Category update(@RequestBody Category category);

    @PostMapping()
    Category save(@RequestBody Category category);

    @DeleteMapping()
    void deleteById(@RequestBody Long id);

}

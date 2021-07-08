package com.github.grizzly.controller;

import com.github.grizzly.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ICategoryController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @PutMapping
    CategoryDto update(@RequestBody CategoryDto category);

    @PostMapping()
    CategoryDto save(@RequestBody CategoryDto category);

    @DeleteMapping()
    void deleteById(@RequestBody Long id);

}

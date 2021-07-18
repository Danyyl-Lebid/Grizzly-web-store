package com.github.grizzly.controller;

import com.github.grizzly.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ICategoryController {

    @GetMapping(path = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @PutMapping(path = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto update(@RequestBody CategoryDto category);

    @PostMapping(path = "/add-new", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto category);

    @DeleteMapping(path = "/delete-{id}")
    void deleteById(@RequestBody Long id);

}

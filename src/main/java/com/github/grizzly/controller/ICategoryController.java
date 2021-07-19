package com.github.grizzly.controller;

import com.github.grizzly.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ICategoryController {

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping(path = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @Secured("ROLE_ADMIN")
    @PutMapping(path = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto update(@RequestBody CategoryDto category);

    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/add-new", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto category);

    @Secured("ROLE_ADMIN")
    @DeleteMapping(path = "/delete-{id}")
    void deleteById(@RequestBody Long id);

}

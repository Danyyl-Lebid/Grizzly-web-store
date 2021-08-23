package com.github.grizzly.controller;

import com.github.grizzly.dto.ProductDto;
import com.github.grizzly.entity.ActiveState;
import com.github.grizzly.enums.Status;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IProductController {

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping(path = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductDto> findAll();

    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/find-all-{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductDto> findAllProductByStatus(@PathVariable("status") ActiveState activeState);

    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/add-new", produces = MediaType.APPLICATION_JSON_VALUE)
    ProductDto save(@RequestBody ProductDto payload);

    @Secured("ROLE_ADMIN")
    @PutMapping(path = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody ProductDto payload);

    @Secured("ROLE_ADMIN")
    @DeleteMapping(path = "/delete-{id}")
    void deleteProductById(@PathVariable(name = "id") Long id);

}

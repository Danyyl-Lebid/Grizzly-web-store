package com.github.grizzly.controller;

import com.github.grizzly.dto.OrderDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IOrderController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> findAllOrderByUserId();

    @PostMapping
    OrderDto save(@RequestBody OrderDto payload);

    @PutMapping
    void update(@RequestBody OrderDto payload);

    @DeleteMapping(path = "/{id}")
    void deleteById(@PathVariable(name = "id") Long id);
}

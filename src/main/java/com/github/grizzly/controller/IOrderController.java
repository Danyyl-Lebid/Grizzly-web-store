package com.github.grizzly.controller;

import com.github.grizzly.dto.order.DistributeOrderDto;
import com.github.grizzly.dto.order.OrderDto;
import com.github.grizzly.enums.Status;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IOrderController {

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<OrderDto>> findAll();

    @GetMapping(path = "/all-{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<OrderDto>> findAllByStatus(@PathVariable("status") Status status);

    @GetMapping(path = "/my-orders/{userId}/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<OrderDto>> findAllOrderByUserId(@PathVariable("userId") long userId, @RequestHeader("authorization") String jwtToken);

    @GetMapping(path = "/my-orders/{userId}/all-{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<OrderDto>> findAllOrderByUserIdAndByStatusCreateDateDesc(@PathVariable("userId") long userId, @PathVariable("status") Status status, @RequestHeader("authorization") String jwtToken);

    @PostMapping (path = "/my-orders/{userId}/add", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<OrderDto> save(@PathVariable("userId") long userId, @RequestHeader("authorization") String jwtToken, @RequestBody DistributeOrderDto payload);

    @PutMapping
    void update(@RequestBody OrderDto payload);

    @DeleteMapping(path = "/{id}")
    void deleteById(@PathVariable(name = "id") Long id);
}

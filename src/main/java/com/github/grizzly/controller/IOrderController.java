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

    @GetMapping(path = "/my-orders/{userId}/order-{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<OrderDto> findOrderById(@PathVariable("userId") long userId, @PathVariable("orderId") long orderId, @RequestHeader("authorization") String jwtToken);

    @GetMapping(path = "/my-orders/{userId}/all-{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<OrderDto>> findAllOrderByUserIdAndByStatusCreateDateDesc(@PathVariable("userId") long userId, @PathVariable("status") Status status, @RequestHeader("authorization") String jwtToken);

    @PostMapping (path = "/my-orders/{userId}/add", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<OrderDto> save(@PathVariable("userId") long userId, @RequestHeader("authorization") String jwtToken, @RequestBody DistributeOrderDto payload);

    @PutMapping(path = "/my-orders/{userId}/update", produces = MediaType.APPLICATION_JSON_VALUE)
    void updateOrderStatus(@RequestBody OrderDto payload);

    @DeleteMapping(path = "/my-orders/{userId}/delete-{orderId}")
    void deleteById(@PathVariable("orderId") long orderId);
}

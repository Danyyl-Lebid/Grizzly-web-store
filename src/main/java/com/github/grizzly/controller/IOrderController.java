package com.github.grizzly.controller;

import com.github.grizzly.dto.order.DistributeOrderDto;
import com.github.grizzly.dto.order.OrderDto;
import com.github.grizzly.enums.Status;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IOrderController {

    @GetMapping(path = "/admin/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> findAll();

    @GetMapping(path = "/admin/all-{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> findAllByStatus(@PathVariable("status") Status status);

//    @GetMapping(path = "/user/all", produces = MediaType.APPLICATION_JSON_VALUE)
//    List<OrderDto> findAllOrderByUserId(@CurrentSecurityContext(expression="authentication") Authentication authentication);

    @GetMapping(path = "/user/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> findAllOrderByUserId(@RequestHeader("authorization") String jwtToken);

    @GetMapping(path = "/user/order-{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderDto findOrderById(@PathVariable("orderId") long orderId);

    @GetMapping(path = "/user/all-{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> findAllOrderByUserIdAndByStatusCreateDateDesc(@PathVariable("status") Status status, @RequestHeader("authorization") String jwtToken);

    @PostMapping (path = "/user/add", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderDto save(@RequestHeader("authorization") String jwtToken, @RequestBody DistributeOrderDto payload);

    @PutMapping(path = "/user/update", produces = MediaType.APPLICATION_JSON_VALUE)
    void updateOrderStatus(@RequestBody OrderDto payload);

    @DeleteMapping(path = "/user/delete-{orderId}")
    void deleteById(@PathVariable("orderId") long orderId);
}

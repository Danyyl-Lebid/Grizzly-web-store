package com.github.grizzly.controller;

import com.github.grizzly.dto.order.DistributeOrderDto;
import com.github.grizzly.dto.order.OrderDto;
import com.github.grizzly.enums.Status;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IOrderController {
    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> findAll();

    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/all-{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> findAllByStatus(@PathVariable("status") Status status);

//    @GetMapping(path = "/user/all", produces = MediaType.APPLICATION_JSON_VALUE)
//    List<OrderDto> findAllOrderByUserId(@CurrentSecurityContext(expression="authentication") Authentication authentication);

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping(path = "/user/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> findAllOrderByUserId(@RequestHeader("authorization") String jwtToken);

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping(path = "/user/order-{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderDto findOrderById(@PathVariable("orderId") long orderId);

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping(path = "/user/all-{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> findAllOrderByUserIdAndByStatusCreateDateDesc(@PathVariable("status") Status status, @RequestHeader("authorization") String jwtToken);

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @PostMapping (path = "/user/add", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderDto save(@RequestHeader("authorization") String jwtToken, @RequestBody DistributeOrderDto payload);

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @PutMapping(path = "/user/update", produces = MediaType.APPLICATION_JSON_VALUE)
    void updateOrderStatus(@RequestBody OrderDto payload);

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @DeleteMapping(path = "/user/delete-{orderId}")
    void deleteById(@PathVariable("orderId") long orderId);
}

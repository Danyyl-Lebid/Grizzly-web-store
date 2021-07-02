package com.github.grizzly.controller.impl;

import com.github.grizzly.controller.IOrderController;
import com.github.grizzly.dto.order.DistributeOrderDto;
import com.github.grizzly.dto.order.OrderDto;
import com.github.grizzly.dto.order.OrderItemsDto;
import com.github.grizzly.entity.Order;
import com.github.grizzly.entity.OrderItem;
import com.github.grizzly.entity.Product;
import com.github.grizzly.entity.User;
import com.github.grizzly.enums.Status;
import com.github.grizzly.exceptions.EntityNotFoundException;
import com.github.grizzly.repository.ProductRepository;
import com.github.grizzly.security.CustomUserDetails;
import com.github.grizzly.security.CustomUserDetailsService;
import com.github.grizzly.security.jwt.JwtProvider;
import com.github.grizzly.service.IOrderItemService;
import com.github.grizzly.service.IOrderService;
import com.github.grizzly.service.IProductService;
import com.github.grizzly.service.IUserService;
import com.github.grizzly.utils.OrderItemTransferObject;
import com.github.grizzly.utils.OrderTransferObject;
import com.github.grizzly.utils.TransferObj;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/order")
@RequiredArgsConstructor
public class OrderController implements IOrderController {

    @Autowired
    private final IOrderService orderService;

    @Autowired
    private final IUserService userService;

    @Autowired
    private final IOrderItemService orderItemService;

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> findAll() {
        return this.orderService.readAll()
                .stream()
                .map(OrderTransferObject::fromOrder)
                .collect(Collectors.toList());
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> findAllByStatus(Status status) {
        return this.orderService.readAllOrdersByStatus(status)
                .stream()
                .map(OrderTransferObject::fromOrder)
                .collect(Collectors.toList());
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> findAllOrderByUserId(String jwtToken) {
        String login = jwtProvider.getLoginFromToken(jwtToken);
        User user = this.userService.findByLogin(login);
        return this.orderService.readAllOrderByUser(user)
                .stream()
                .map(OrderTransferObject::fromOrder)
                .collect(Collectors.toList());
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public OrderDto findOrderById(long orderId) {
        Order order = this.orderService.findOrderById(orderId).orElseThrow(EntityNotFoundException::new);
        return OrderTransferObject.fromOrder(order);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> findAllOrderByUserIdAndByStatusCreateDateDesc(Status status, String jwtToken) {
        String login = jwtProvider.getLoginFromToken(jwtToken);
        User user = this.userService.findByLogin(login);
        return this.orderService.readAllOrderByUserAndByStatus(user, status)
                .stream()
                .map(OrderTransferObject::fromOrder)
                .collect(Collectors.toList());
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto save(String jwtToken, DistributeOrderDto payload) {
        String login = jwtProvider.getLoginFromToken(jwtToken);
        User user = this.userService.findByLogin(login);
        Order order = this.orderService.create(user);
        List<OrderItem> orderItems = payload.getOrderItems()
                .stream()
                .map(orderItemsDto -> this.orderItemService.create(orderItemsDto, order))
                .collect(Collectors.toList());
        order.setOrderItems(orderItems);
        return OrderTransferObject.fromOrder(order);
    }

    @Override
    public void updateOrderStatus(OrderDto payload) {
        Order order= this.orderService.findOrderById(payload.getId()).orElseThrow(NoSuchElementException::new);
        Status newStatus = payload.getStatus();
        if(!order.getStatus().equals(newStatus)) {
            order.setStatus(newStatus);
            this.orderService.update(order);
        }
    }

    @Override
    public void deleteById(long orderId) {
        this.orderService.deleteById(orderId);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNoSuchElementFoundException(
            NoSuchElementException exception
    ) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("No such order!");
    }
}

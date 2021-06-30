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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    JwtProvider jwtProvider;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public ResponseEntity<List<OrderDto>> findAll() {
        return new ResponseEntity<>(this.orderService.readAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public ResponseEntity<List<OrderDto>> findAllByStatus(Status status) {
        return new ResponseEntity<>(this.orderService.readAllOrdersByStatus(status), HttpStatus.OK);
    }

//    Need something like that @PreAuthorize("hasRole('ROLE_ADMIN') or #User.getId == #userId")
    @Override
    public ResponseEntity<List<OrderDto>> findAllOrderByUserId(long userId, String jwtToken) {
        User user = this.userService.findById(userId);
        return new ResponseEntity<>(this.orderService.readAllOrderByUser(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDto> findOrderById(long userId, long orderId, String jwtToken) {
        Order order = this.orderService.findOrderById(orderId).orElseThrow(EntityNotFoundException::new);
        return new ResponseEntity<>(OrderTransferObject.fromOrder(order), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<OrderDto>> findAllOrderByUserIdAndByStatusCreateDateDesc(long userId, Status status, String jwtToken) {
        User user = this.userService.findById(userId);
        return new ResponseEntity<>(this.orderService.readAllOrderByUserAndByStatus(user, status), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDto> save(long userId, String jwtToken, DistributeOrderDto payload) {
        User user = this.userService.findById(userId);
        Order order = this.orderService.create(user);
        List<OrderItem> orderItems = payload.getOrderItems()
                .stream()
                .map(orderItemsDto -> this.orderItemService.create(orderItemsDto, order))
                .collect(Collectors.toList());
        order.setOrderItems(orderItems);
        return new ResponseEntity<>(OrderTransferObject.fromOrder(order), HttpStatus.CREATED);
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

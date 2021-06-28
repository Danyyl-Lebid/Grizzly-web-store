package com.github.grizzly.service;

import com.github.grizzly.dto.order.OrderDto;
import com.github.grizzly.entity.Order;
import com.github.grizzly.entity.User;
import com.github.grizzly.enums.Status;

import java.util.List;

public interface IOrderService {

    List<OrderDto> readAll();

    List<OrderDto> readAllOrdersByStatus(Status status);

    List<OrderDto> readAllOrderByUser(User user);

    List<OrderDto> readAllOrderByUserAndByStatus(User user, Status status);

    Order create(User user);

    void update(Order order);

    void deleteById(Long id);

}

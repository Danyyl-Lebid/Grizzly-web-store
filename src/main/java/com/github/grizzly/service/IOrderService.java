package com.github.grizzly.service;

import com.github.grizzly.entity.Order;
import com.github.grizzly.entity.User;
import com.github.grizzly.enums.Status;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    List<Order> readAll();

    List<Order> readAllOrdersByStatus(Status status);

    List<Order> readAllOrderByUser(User user);

    List<Order> readAllOrderByUserAndByStatus(User user, Status status);

    Optional<Order> findOrderById(long id);

    Order create(User user);

    void update(Order order);

    void deleteById(Long id);

}

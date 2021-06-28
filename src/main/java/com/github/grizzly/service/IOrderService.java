package com.github.grizzly.service;

import com.github.grizzly.entity.Order;
import com.github.grizzly.entity.User;
import com.github.grizzly.enums.Status;

import java.util.List;

public interface IOrderService {

    List<Order> readAll();

    List<Order> readAllOrderByUser(User user);

    List<Order> readAllOrderByStatus(Status status);

    Order create(Order order);

    void update(Order order);

    void deleteById(Long id);

}

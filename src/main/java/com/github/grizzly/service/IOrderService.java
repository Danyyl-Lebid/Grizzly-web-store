package com.github.grizzly.service;

import com.github.grizzly.dto.order.OrderDto;
import com.github.grizzly.entity.Order;
import com.github.grizzly.entity.User;
import com.github.grizzly.enums.Status;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IOrderService {

    List<OrderDto> readAll();

    List<OrderDto> readAllOrdersByStatus(Status status);

    List<OrderDto> readAllOrderByUser(User user);

    List<OrderDto> readAllOrderByUserAndByStatus(User user, Status status);

    Optional<Order> findOrderById(long id);

    Order create(User user);

    void update(Order order);

    void deleteById(Long id);

}

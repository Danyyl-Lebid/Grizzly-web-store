package com.github.grizzly.service.impl;

import com.github.grizzly.dto.order.OrderDto;
import com.github.grizzly.entity.ActiveState;
import com.github.grizzly.entity.Order;
import com.github.grizzly.entity.User;
import com.github.grizzly.enums.Status;
import com.github.grizzly.repository.OrderRepository;
import com.github.grizzly.service.IOrderService;
import com.github.grizzly.utils.OrderTransferObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    OrderItemService orderItemService;

    @Override
    public List<Order> readAll() {

        return this.orderRepository.findAll()
                .stream()
                .filter(order -> order.getState().equals(ActiveState.ON))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> readAllOrdersByStatus(Status status) {
        return this.orderRepository.findOrderByStatus(status);
    }

    @Override
    public List<Order> readAllOrderByUser(User user) {
        return this.orderRepository.findAllByUserOrderByCreateDateDesc(user);
    }

    @Override
    public List<Order> readAllOrderByUserAndByStatus(User user, Status status) {
        return this.orderRepository.findAllByUserAndStatusOrderByCreateDateDesc(user, status);
    }

    @Override
    public Optional <Order> findOrderById(long id) {
        return this.orderRepository.findById(id);
    }


    @Override
    public Order create(User user) {
        Order order = new Order(user);
        return this.orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
            this.orderRepository.deleteById(id);
    }
}

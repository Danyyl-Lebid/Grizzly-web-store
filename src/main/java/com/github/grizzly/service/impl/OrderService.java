package com.github.grizzly.service.impl;

import com.github.grizzly.entity.Order;
import com.github.grizzly.entity.User;
import com.github.grizzly.enums.Status;
import com.github.grizzly.repository.OrderRepository;
import com.github.grizzly.service.IOrderService;
import com.github.grizzly.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    OrderItemsService orderItemsService;

    @Override
    public List<Order> readAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public List<Order> readAllOrderByUser(User user) {
        return this.orderRepository.findAllByUserOrderByCreateDateDesc(user);
    }

    @Override
    public List<Order> readAllOrderByStatus(Status status) {
        return this.orderRepository.findOrderByStatus(status);
    }

    @Override
    public Order create(Order order) {
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

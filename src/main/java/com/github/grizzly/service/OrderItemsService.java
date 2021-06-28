package com.github.grizzly.service;

import com.github.grizzly.entity.OrderItem;
import com.github.grizzly.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemRepository;

    private void addOrderedProduct(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }


}

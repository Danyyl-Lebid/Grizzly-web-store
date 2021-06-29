package com.github.grizzly.service.impl;

import com.github.grizzly.dto.order.OrderItemsDto;
import com.github.grizzly.entity.Order;
import com.github.grizzly.entity.OrderItem;
import com.github.grizzly.entity.Product;
import com.github.grizzly.repository.OrderItemsRepository;
import com.github.grizzly.repository.ProductRepository;
import com.github.grizzly.service.IOrderItemService;
import com.github.grizzly.utils.OrderItemTransferObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderItemService implements IOrderItemService {

    @Autowired
    private OrderItemsRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public OrderItem create(OrderItemsDto orderItemDto, Order order) {
        Product product = this.productRepository.getById(orderItemDto.getProductId());
        OrderItem orderItem = OrderItemTransferObject.toOrderItem(orderItemDto, order, product);
        return this.orderItemRepository.save(orderItem);
    }
}

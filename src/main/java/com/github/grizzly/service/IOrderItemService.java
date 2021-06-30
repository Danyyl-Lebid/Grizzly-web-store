package com.github.grizzly.service;

import com.github.grizzly.dto.order.OrderItemsDto;
import com.github.grizzly.entity.Order;
import com.github.grizzly.entity.OrderItem;

public interface IOrderItemService {

    OrderItem create(OrderItemsDto orderItemsDto, Order order);
}

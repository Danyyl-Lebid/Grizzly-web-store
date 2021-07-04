package com.github.grizzly.utils;

import com.github.grizzly.dto.order.OrderDto;
import com.github.grizzly.entity.Order;
import com.github.grizzly.entity.OrderItem;
import com.github.grizzly.entity.Product;
import com.github.grizzly.entity.User;
import com.github.grizzly.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class OrderTransferObject {

    public static OrderDto fromOrder(Order order){
        return new OrderDto(
                order.getId(),
                order.getUser().getId(),
                order.getCreateDate(),
                order.getStatus(),
                order.getOrderItems()
                        .stream()
                        .map(OrderItemTransferObject::fromOrderItem)
                        .collect(Collectors.toList()),
                order.getTotalOrderPrice()
        );
    }
}

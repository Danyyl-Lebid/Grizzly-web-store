package com.github.grizzly.utils;

import com.github.grizzly.dto.OrderDto;
import com.github.grizzly.dto.OrderItemsDto;
import com.github.grizzly.entity.Order;
import com.github.grizzly.entity.OrderItem;
import com.github.grizzly.entity.Product;
import com.github.grizzly.entity.User;

public class TransferObj {

    public static Order toOrder(OrderDto data) {
        return new Order(
                data.getId(),
                data.getCreateDate(),
                data.getStatus(),
                data.getOrderItems(),
                new User(data.getUserId())
        );
    }

    public static OrderDto fromOrder(Order order){
        return new OrderDto(
                order.getId(),
                order.getCreateDate(),
                order.getStatus(),
                order.getUser().getId(),
                order.getOrderItems()
        );
    }

    public static OrderItemsDto toOrderItemDto(OrderItem orderItems) {
        return new OrderItemsDto(
                orderItems.getQuantity(),
                orderItems.getPrice(),
                orderItems.getOrder().getId(),
                orderItems.getProduct().getId()
        );
    }

    public static OrderItem toOrderItems(OrderItemsDto data) {
        return new OrderItem(
                data.getQuantity(),
                data.getPrice(),
                new Order(data.getOrderId()),
                new Product(data.getProductId())
        );
    }
}

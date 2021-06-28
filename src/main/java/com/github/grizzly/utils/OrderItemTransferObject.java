package com.github.grizzly.utils;

import com.github.grizzly.dto.order.OrderItemsDto;
import com.github.grizzly.entity.Order;
import com.github.grizzly.entity.OrderItem;
import com.github.grizzly.entity.Product;

public class OrderItemTransferObject {

    public static OrderItem toOrderItem(OrderItemsDto orderItemDto, Order order, Product product) {
        return new OrderItem(
                orderItemDto.getQuantity(),
                orderItemDto.getPrice(),
                order,
                product
        );
    }

    public static OrderItemsDto fromOrderItem(OrderItem orderItem){
        return new OrderItemsDto(
                orderItem.getQuantity(),
                orderItem.getPrice(),
                orderItem.getOrder().getId(),
                orderItem.getProduct().getId()
        );
    }
}

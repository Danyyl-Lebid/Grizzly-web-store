package com.github.grizzly.dto;

public class OrderItemDto {
    private double price;
    private int quantity;
    private long orderId;
    private long productId;

    public OrderItemDto() {
    }

    public OrderItemDto(double price, int quantity, long orderId, long productId) {
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.productId = productId;
    }
}


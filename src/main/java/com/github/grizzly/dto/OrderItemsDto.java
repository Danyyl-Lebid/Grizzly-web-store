package com.github.grizzly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsDto {

    private int quantity;

    private BigDecimal price;

    private long orderId;

    private long productId;

}


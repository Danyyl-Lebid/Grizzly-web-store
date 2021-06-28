package com.github.grizzly.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistributeOrderDto {

    private List<OrderItemsDto> orderItems;
}

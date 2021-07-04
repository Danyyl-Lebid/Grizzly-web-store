package com.github.grizzly.dto.order;

import com.github.grizzly.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private long id;

    private long userId;

    private LocalDateTime createDate;

    private Status status;

    private List<OrderItemsDto> orderItems;

    private BigDecimal totalPrice;

}

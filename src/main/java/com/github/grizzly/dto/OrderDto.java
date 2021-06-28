package com.github.grizzly.dto;

import com.github.grizzly.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private long id;

    private LocalDateTime createDate;

    private Status status;

    private long userId;

    private List<OrderItemsDto> orderItems;

}

package com.github.grizzly.controller;

import com.github.grizzly.dto.OrderDto;
import com.github.grizzly.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
@RequiredArgsConstructor
public class OrderController implements IOrderController {

    private final IOrderService orderService;

    @Override
    public List<OrderDto> findAllOrderByUserId() {
        return this.productService.readAll().stream()
                .map(TransferObj::fromProduct)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto save(OrderDto payload) {
        return null;
    }

    @Override
    public void update(OrderDto payload) {

    }

    @Override
    public void deleteById(Long id) {

    }
}

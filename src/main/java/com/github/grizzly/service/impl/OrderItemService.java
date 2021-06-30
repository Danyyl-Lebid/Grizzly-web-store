package com.github.grizzly.service.impl;

import com.github.grizzly.dto.order.OrderItemsDto;
import com.github.grizzly.entity.Order;
import com.github.grizzly.entity.OrderItem;
import com.github.grizzly.entity.Product;
import com.github.grizzly.exceptions.EntityNotFoundException;
import com.github.grizzly.repository.OrderItemsRepository;
import com.github.grizzly.repository.ProductRepository;
import com.github.grizzly.service.IOrderItemService;
import com.github.grizzly.utils.OrderItemTransferObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class OrderItemService implements IOrderItemService {

    @Autowired
    private OrderItemsRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public OrderItem create(OrderItemsDto orderItemDto, Order order) {

        Optional <Product> product = this.productRepository.findById(orderItemDto.getProductId());
        if(product.isEmpty()){
            throw new EntityNotFoundException("No such product!");
        }
        OrderItem orderItem = OrderItemTransferObject.toOrderItem(orderItemDto, order, product.get());
        return this.orderItemRepository.save(orderItem);
    }
}

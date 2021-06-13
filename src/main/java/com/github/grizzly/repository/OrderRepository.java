package com.github.grizzly.repository;

import com.github.grizzly.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JPARepository<Order> {

    List<Order> findAllByUserIdOrder(long userId);

}

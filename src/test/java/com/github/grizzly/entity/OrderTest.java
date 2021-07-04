package com.github.grizzly.entity;

import com.github.grizzly.enums.Status;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;


public class OrderTest {
    Product product1 = new Product();

    Product product2 = new Product();

    OrderItem orderItem1 = new OrderItem(1L, 2, new BigDecimal(12.22d), new Order(), product1);

    OrderItem orderItem2 = new OrderItem(2L, 3, new BigDecimal(2.55d), new Order(), product2);

    Order order = new Order(
            1L,
            LocalDateTime.now(),
            LocalDateTime.now(),
            Status.OPEN,
            List.of(orderItem1, orderItem2),
            new User());


    @Test
    public void getTotalPrice(){
        BigDecimal exp = new BigDecimal(32.09d).setScale(2, RoundingMode.HALF_EVEN);;
        BigDecimal act = order.getTotalOrderPrice();
        System.out.println("EXP: " + exp + "; ACT: " + act);
        Assert.assertEquals(exp, act);
    }

}
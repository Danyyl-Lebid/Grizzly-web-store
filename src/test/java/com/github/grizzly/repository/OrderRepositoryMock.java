package com.github.grizzly.repository;

import com.github.grizzly.entity.*;
import com.github.grizzly.enums.Status;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrderRepositoryMock {

    private static Order order1 = new Order(
                1L,
                LocalDateTime.of(2020, Month.JULY, 29, 19, 30, 40),
                LocalDateTime.of(2020, Month.JULY, 29, 19, 30, 40),
                Status.OPEN,
                new ArrayList<>(),
                user1()
        );

    private static Order order2 = new Order(
            2L,
            LocalDateTime.of(2020, Month.JULY, 29, 19, 30, 40),
            LocalDateTime.of(2020, Month.JULY, 29, 19, 30, 40),
            Status.OPEN,
            new ArrayList<>(),
            user2()
    );

    private static Order order3 = new Order(
            3L,
            LocalDateTime.of(2020, Month.JULY, 29, 19, 30, 40),
            LocalDateTime.of(2020, Month.JULY, 29, 19, 30, 40),
            Status.OPEN,
            new ArrayList<>(),
            user1()
    );

    private static Order order4 = new Order(
            4L,
            LocalDateTime.of(2020, Month.MARCH, 29, 19, 30, 40),
            LocalDateTime.of(2020, Month.MARCH, 29, 19, 30, 40),
            Status.COMPLETED,
            new ArrayList<>(),
            user1()
        );

    private static Order order5 = new Order(
            5L,
            LocalDateTime.of(2021, Month.APRIL, 29, 19, 30, 40),
            LocalDateTime.of(2021, Month.APRIL, 29, 19, 30, 40),
            Status.OPEN,
            new ArrayList<> (),
            user1()
    );

    private static Order order6 = new Order(
            6L,
            LocalDateTime.of(2021, Month.MAY, 29, 19, 30, 40),
            LocalDateTime.of(2021, Month.MAY, 29, 19, 30, 40),
            Status.COMPLETED,
            new ArrayList<> (),
            user2()
    );

    public static User user1() {
        return new User(1L,
                "user1_firstName",
                "user1_lastName",
                "user1_login",
                "user1_password",
                "user1_@email.com",
                "user1_phone"

        );
    }

    public static User user2() {
        return new User(2L,
                "user2_firstName",
                "user2_lastName",
                "user2_login",
                "user2_password",
                "user2_@email.com",
                "user2_phone",
                LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0, 0)
        );
    }


    public static Category category(){
        return new Category(1L, null, "product", "products");
    }

    public static Product product1() {
        return new Product(
                1L,
                "Milk",
                "2,6%",
                null,
                new BigDecimal("11.22"),
                11,
                category()
        );
    }

    public static Product product2() {
        return new Product(
                2L,
                "Bread",
                "yammi",
                null,
                new BigDecimal("3.33"),
                110,
                category()
        );
    }

    public static Product product3() {
        return new Product(
                3L,
                "Cheese",
                "40%",
                null,
                new BigDecimal("89.70"),
                13,
                category()
        );
    }


    public static OrderItem orderItem1(){
        return new OrderItem(
                1L,
                3,
                new BigDecimal("11.22"),
                order1,
                product1()
        );
    }

    public static OrderItem orderItem2(){
        return new OrderItem(
                2L,
                5,
                new BigDecimal("3.33"),
                order1,
                product2()
        );
    }

    public static OrderItem orderItem3(){
        return new OrderItem(
                3L,
                1,
                new BigDecimal("89.70"),
                order1,
                product3()
        );
    }

    public static OrderItem orderItem4(){
        return new OrderItem(
                4L,
                2,
                new BigDecimal("11.22"),
                order2,
                product1()
        );
    }

    public static OrderItem orderItem5(){
        return new OrderItem(
                5L,
                1,
                new BigDecimal("3.33"),
                order2,
                product2()
        );
    }

    public static OrderItem orderItem6(){
        return new OrderItem(
                6L,
                1,
                new BigDecimal("3.33"),
                order3,
                product2()
        );
    }

    public static OrderItem orderItem7(){
        return new OrderItem(
                7L,
                10,
                new BigDecimal("89.70"),
                order3,
                product3()
        );
    }

    public static List<OrderItem>  list1(){
        return List.of(orderItem1(), orderItem2(), orderItem3());
    }

    public static List<OrderItem>  list2(){
        return List.of(orderItem4(), orderItem5());
    }

    public static List<OrderItem>  list3(){
        return List.of(orderItem6(), orderItem7());
    }


    public static Order order1() {
        Order order = order1;
        order.setOrderItems(list1());
        return order;
    }

    public static Order order2() {
        Order order = order2;
        order.setOrderItems(list2());
        return order;
    }

    public static Order order3() {
        Order order = order3;
        order.setOrderItems(list3());
        return order;
    }

    public static Order orderAlwaysNew5() {
        Order order5 = new Order(
                5L,
                LocalDateTime.of(2021, Month.APRIL, 29, 19, 30, 40),
                LocalDateTime.of(2021, Month.APRIL, 29, 19, 30, 40),
                Status.OPEN,
                new ArrayList<> (),
                user1()
        );
        return order5;
    }

    public static Order orderAlwaysNew6() {
        Order order6 = new Order(
                6L,
                LocalDateTime.of(2021, Month.MAY, 29, 19, 30, 40),
                LocalDateTime.of(2021, Month.MAY, 29, 19, 30, 40),
                Status.COMPLETED,
                new ArrayList<> (),
                user2()
        );
        return order6;
    }

    public static Order order4() {
        Order order = order4;
        return order;
    }

    public static List<Order> orders() {
        return List.of(
                order1(),
                order2(),
                order3(),
                order4()
        );
    }

    public static List<Order> ordersById() {
        return List.of(
                order1(),
                order3()
        );
    }

    public static List<Order> ordersUser1Desc() {
        return List.of(
                order3(),
                order4(),
                order1()
        );
    }

    public static List<Order> ordersWithCompletedStatus() {
        return List.of(
                order4()
        );
    }

    public static List<Order> ordersAfterDelete() {
        return List.of(
                order1(),
                order3(),
                order4()
        );
    }
}

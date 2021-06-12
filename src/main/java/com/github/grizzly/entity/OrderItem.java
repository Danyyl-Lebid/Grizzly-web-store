package com.github.grizzly.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

//@Entity
//@Table(name = "orderitems")
public class OrderItem {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderItemId;

//    @Column(name = "productId")
    private @NotNull long productId;

//    @Column(name = "quantity")
    private @NotNull int quantity;

//    @Column(name = "price")
    private @NotNull double price;

//    @Column(name = "order_id")
    private long orderId;

//    @Column(name = "created_date")
    private Date createdDate;

//    @ManyToOne
//    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;

//    @OneToOne
//    @JoinColumn(name = "productId", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    public OrderItem() {
    }

    public OrderItem(long orderId, @NotNull long product_id, @NotNull int quantity, @NotNull double price) {
        this.productId = product_id;
        this.quantity = quantity;
        this.price = price;
        this.orderId = orderId;
        this.createdDate = new Date();
    }
}
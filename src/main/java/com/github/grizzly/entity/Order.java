package com.github.grizzly.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 123243L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(name = "user_id")
    private long userId;

//    @Column(name = "created_date")
    private Date createdDate;

//    @Column(name = "total_price")
    private Double totalPrice;

//    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
//    @JoinColumn(name = "order_id",referencedColumnName = "id", insertable = false, updatable = false)
    private List<OrderItem> orderItems;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    public Order() {
    }

//    public Order(PlaceOrderDto orderDto, long userId){
//        this.userId = userId;
//        this.createdDate = new Date();
//        this.totalPrice = orderDto.getTotalPrice();
//
//    }
}
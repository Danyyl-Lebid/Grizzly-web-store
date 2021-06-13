package com.github.grizzly.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (userId != order.userId) return false;
        if (createdDate != null ? !createdDate.equals(order.createdDate) : order.createdDate != null) return false;
        if (totalPrice != null ? !totalPrice.equals(order.totalPrice) : order.totalPrice != null) return false;
        if (orderItems != null ? !orderItems.equals(order.orderItems) : order.orderItems != null) return false;
        return user != null ? user.equals(order.user) : order.user == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (orderItems != null ? orderItems.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

//    public Order(PlaceOrderDto orderDto, long userId){
//        this.userId = userId;
//        this.createdDate = new Date();
//        this.totalPrice = orderDto.getTotalPrice();
//
//    }
}

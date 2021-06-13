package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

//@Entity
//@Table(name = "orderitems")
@Getter
@Setter
@NoArgsConstructor
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (orderItemId != orderItem.orderItemId) return false;
        if (productId != orderItem.productId) return false;
        if (quantity != orderItem.quantity) return false;
        if (Double.compare(orderItem.price, price) != 0) return false;
        if (orderId != orderItem.orderId) return false;
        if (createdDate != null ? !createdDate.equals(orderItem.createdDate) : orderItem.createdDate != null)
            return false;
        if (order != null ? !order.equals(orderItem.order) : orderItem.order != null) return false;
        return product != null ? product.equals(orderItem.product) : orderItem.product == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (orderItemId ^ (orderItemId >>> 32));
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        result = 31 * result + quantity;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }

    //    public OrderItem(long orderId, @NotNull long product_id, @NotNull int quantity, @NotNull double price) {
//        this.productId = product_id;
//        this.quantity = quantity;
//        this.price = price;
//        this.orderId = orderId;
//        this.createdDate = new Date();
//    }
}
package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE order_items SET state = 'OFF' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Table(name = "order_items")
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @Setter(value = AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "quantity")
    private int quantity;

    @NotNull
    @Column(name = "price")
    @Digits(integer = 9, fraction = 2)
    private BigDecimal price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @NotNull
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @NotNull
    @Column(name = "state", columnDefinition = "VARCHAR(32)")
    @Enumerated(EnumType.STRING)
    private ActiveState state;

    @Transient
    public BigDecimal getTotalPrice() {
        return getPrice().multiply(BigDecimal.valueOf(getQuantity()));
    }

    public OrderItem(int quantity,
                     @Digits(integer = 9, fraction = 2) BigDecimal price,
                     Order order,
                     Product product) {
        this.quantity = quantity;
        this.price = price;
        this.order = order;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;
        if (id != orderItem.id) return false;
        if (quantity != orderItem.quantity) return false;
        if (!Objects.equals(price, orderItem.price)) return false;
        if (order.getId() != orderItem.order.getId()) return false;
        if (product.getId() != orderItem.product.getId()) return false;
        return Objects.equals(state, orderItem.state);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + quantity;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = (int) (31 * result + order.getId());
        result = (int) (31 * result + product.getId());
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", order=" + order.getId() +
                ", product=" + product.getId() +
                ", state=" + state +
                '}';
    }
}
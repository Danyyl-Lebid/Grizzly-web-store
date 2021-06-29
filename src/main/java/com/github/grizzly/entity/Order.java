package com.github.grizzly.entity;
import com.github.grizzly.enums.Status;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Setter(value = AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "modify_date")
    private LocalDateTime modifyDate;

    @NotNull
    @Column(name = "status", columnDefinition = "VARCHAR(32)")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Transient
    @Digits(integer = 9, fraction = 2)
    public BigDecimal getTotalOrderPrice() {
        BigDecimal sum = new BigDecimal("0");
        List<OrderItem> orderItems = getOrderItems();
        if(orderItems == null || orderItems.size() == 0) {
            return sum;
        }
        for (OrderItem orderItem : orderItems) {
            sum = sum.add(orderItem.getTotalPrice());
        }

        return sum.setScale(2, RoundingMode.HALF_EVEN);
    }

    public Order(User user) {
        this.status = Status.OPEN;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (!Objects.equals(createDate, order.createDate)) return false;
        if (!Objects.equals(modifyDate, order.modifyDate)) return false;
        if (status != order.status) return false;
        if(!Objects.deepEquals(
                this.getOrderItems() != null ? this.getOrderItems().toArray() : this,
                (order.getOrderItems() != null ? order.getOrderItems().toArray() : order))) return false;
        return Objects.equals(user, order.user);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (orderItems != null ? orderItems.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}

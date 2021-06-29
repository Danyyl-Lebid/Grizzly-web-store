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

@Data
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
}

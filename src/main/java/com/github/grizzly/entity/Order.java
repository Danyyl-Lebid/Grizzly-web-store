package com.github.grizzly.entity;
import com.github.grizzly.enums.Status;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    public Order(long id, LocalDateTime createDate, Status status,
                 List<OrderItem> orderItems, User user) {
        this.id = id;
        this.createDate = createDate;
        this.status = status;
        this.orderItems = orderItems;
        this.user = user;
    }

    public Order(long id) {
        this.id = id;
    }
}

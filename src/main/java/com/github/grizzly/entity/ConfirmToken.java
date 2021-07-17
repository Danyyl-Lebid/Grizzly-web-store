package com.github.grizzly.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "confirm_token")
public class ConfirmToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @Column(name = "token",nullable = false,unique = true)
    private String token;

    @Column(name = "new_pass")
    private String newPass;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private ActiveState status = ActiveState.ON;

    @Column(name = "create_at", columnDefinition = "TIMESTAMP")
    private Date createAt = new Date();

    public ConfirmToken(User user, String token, String newPass) {
        this.user = user;
        this.token = token;
        this.newPass = newPass;
    }
}

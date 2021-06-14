package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "first_name",columnDefinition = "VARCHAR(50)")
    private String firstName;

    @NotNull
    @Column(name = "last_name",columnDefinition = "VARCHAR(50)")
    private String lastName;

    @NotNull
    @Column(name = "login",columnDefinition = "VARCHAR(32)")
    private String login;

    @NotNull
    @Column(name = "password",columnDefinition = "VARCHAR(16)")
    private String password;

    @NotNull
    @Column(name = "email",columnDefinition = "VARCHAR(50)")
    private String email;

    @NotNull
    @Column(name = "phone",columnDefinition = "VARCHAR(16)")
    private String phone;

    @NotNull
    @Column(name = "created_at")
    private Date createdAt;

    @NotNull
    @Column(name = "updated_at")
    private Date updatedAt;

    @NotNull
    @Column(name = "active",columnDefinition = "VARCHAR(32)")
    @Enumerated(EnumType.STRING)
    private Active active;

    @NotNull
    @Column(name = "is_verified",columnDefinition = "VARCHAR(32)")
    private String verification;

    @NotNull
    @Column(name = "role",columnDefinition = "VARCHAR(32)")
    private String role;

    public User(String firstName, String lastName, String login, String password, String email, String phone, Date createdAt, Date updatedAt, Active active, String verification, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
        this.verification = verification;
        this.role = role;
    }
}

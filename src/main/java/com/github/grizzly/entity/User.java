package com.github.grizzly.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "USER")
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT(20)")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "active")
    private Active active;

    @Column(name = "is_verified")
    private String verification;

    @Column(name = "role")
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

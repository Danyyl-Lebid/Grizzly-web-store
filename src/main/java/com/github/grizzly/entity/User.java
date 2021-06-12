package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "first_name")
    private final String firstName;

    @NotNull
    @Column(name = "last_name")
    private final String lastName;

    @NotNull
    @Column(name = "password")
    private final String password;

    @NotNull
    @Column(name = "email")
    private final String email;

    @NotNull
    @Column(name = "phone")
    private final String phone;

    public User(String firstName, String lastName, String password, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}

package com.github.grizzly.entity;

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

    @NonNull
    @Column(name = "first_name",columnDefinition = "VARCHAR(50)")
    private String firstName;

    @NonNull
    @Column(name = "last_name",columnDefinition = "VARCHAR(50)")
    private String lastName;

    @NonNull
    @Column(name = "login",columnDefinition = "VARCHAR(32)")
    private String login;

    @NonNull
    @Column(name = "password",columnDefinition = "VARCHAR(16)")
    private String password;

    @NonNull
    @Column(name = "email",columnDefinition = "VARCHAR(50)")
    private String email;

    @NonNull
    @Column(name = "phone",columnDefinition = "VARCHAR(16)")
    private String phone;

    @NonNull
    @Column(name = "created_at")
    private Date createdAt;

    @NonNull
    @Column(name = "updated_at")
    private Date updatedAt;

    @NonNull
    @Column(name = "active",columnDefinition = "VARCHAR(32)")
    @Enumerated(EnumType.STRING)
    private Active active;

    @NonNull
    @Column(name = "is_verified",columnDefinition = "VARCHAR(32)")
    private String verification;

    @NonNull
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

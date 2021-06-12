package com.github.grizzly.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
    @Column(name = "create_at")
    private String createAt;
    @Column(name = "updateA_at")
    private String updateAt;
    @Column(name = "active")
    private Active active;
    @Column(name = "verification")
    private String verification;
    @Column(name = "role")
    private String role;

    public User(long id, String firstName, String lastName, String login, String password, String email, String phone, String createAt, String updateAt, Active active, String verification, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.active = active;
        this.verification = verification;
        this.role = role;
    }
}

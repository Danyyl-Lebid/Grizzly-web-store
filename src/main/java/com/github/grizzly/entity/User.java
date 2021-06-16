package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Column(name = "login",columnDefinition = "VARCHAR(32)", unique = true)
    private String login;

    @NotNull
    @Column(name = "password",columnDefinition = "VARCHAR(16)")
    private String password;

    @NotNull
    @Column(name = "email",columnDefinition = "VARCHAR(50)", unique = true)
    private String email;

    @NotNull
    @Column(name = "phone",columnDefinition = "VARCHAR(16)", unique = true)
    private String phone;

    @NotNull
    @Column(name = "created_at")
    private Date createdAt;

    @NotNull
    @Column(name = "updated_at")
    private Date updatedAt;

    @NotNull
    @Column(name = "active",columnDefinition = "VARCHAR(16)")
    @Enumerated(EnumType.STRING)
    private Active active;

    @NotNull
    @Column(name = "is_verified",columnDefinition = "VARCHAR(16)")
    @Enumerated(EnumType.STRING)
    private Verification verification;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "user_id",referencedColumnName = "id", insertable = false, updatable = false)
    private List<Address> addresses;

    public void addRole(Role role){
        this.roles.add(role);
        role.getUsers().add(this);
    }

    public User(
            String firstName,
            String lastName,
            String login,
            String password,
            String email,
            String phone,
            Date createdAt,
            Date updatedAt
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public enum Active{
        ON,OFF
    }

    public enum Verification{
        YES, NO
    }
}

package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "role", columnDefinition = "VARCHAR(16)", unique = true, updatable = false, nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles role;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    Set<User> users = new HashSet<>();

    public void addUser(User user) {
        this.getUsers().add(user);
        user.addRole(this);
    }

    public Role(long id, Roles role) {
        this.id = id;
        this.role = role;
    }

    public Role(Roles role) {
        this.role = role;
    }

    public enum Roles {
        GUEST, USER, MANAGER, ADMIN
    }
}

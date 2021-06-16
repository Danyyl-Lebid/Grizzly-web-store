package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name = "role", unique = true, columnDefinition = "VARCHAR(16)")
    @Enumerated(EnumType.STRING)
    private Roles role;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    Set<User> users = new HashSet<>();

    public void addUser(User user){
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

    public enum Roles{
        GUEST,USER,MANAGER,ADMIN
    }
}

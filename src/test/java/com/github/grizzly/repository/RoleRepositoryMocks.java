package com.github.grizzly.repository;

import com.github.grizzly.entity.Role;

import java.util.List;

public class RoleRepositoryMocks {

    public static List<Role> roles(){
        return List.of(
                guest(),
                user(),
                manager(),
                admin()
        );
    }

    public static Role guest(){
        return new Role(1L, Role.Roles.GUEST);
    }

    public static Role user(){
        return new Role(2L, Role.Roles.USER);
    }

    public static Role manager(){
        return new Role(3L, Role.Roles.MANAGER);
    }

    public static Role admin(){
        return new Role(4L, Role.Roles.ADMIN);
    }
}

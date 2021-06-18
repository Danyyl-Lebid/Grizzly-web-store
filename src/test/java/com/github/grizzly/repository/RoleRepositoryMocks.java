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
        return new Role(1L, Role.Values.GUEST);
    }

    public static Role user(){
        return new Role(2L, Role.Values.USER);
    }

    public static Role manager(){
        return new Role(3L, Role.Values.MANAGER);
    }

    public static Role admin(){
        return new Role(4L, Role.Values.ADMIN);
    }
}

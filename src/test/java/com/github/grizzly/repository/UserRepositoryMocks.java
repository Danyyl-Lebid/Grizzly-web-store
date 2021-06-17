package com.github.grizzly.repository;

import com.github.grizzly.entity.User;

import java.util.Date;
import java.util.List;

public class UserRepositoryMocks {

    public static List<User> users(){
        return List.of(
                firstUser()
        );
    }

    public static User firstUser() {
        return new User(1L,
                "user1_firstName",
                "user1_lastName",
                "user1_login",
                "user1_password",
                "user_1@email.com",
                "user1_phone",
                new Date(0),
                null
        );
    }
}

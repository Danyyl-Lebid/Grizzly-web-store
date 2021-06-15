package com.github.grizzly.repository;

import com.github.grizzly.entity.Role;
import com.github.grizzly.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserById(long userId);

    User findUserByPhone(String phone);

    User findByEmail(String email);

    User findByLogin(String login);

    User findByRole(Role role);

}

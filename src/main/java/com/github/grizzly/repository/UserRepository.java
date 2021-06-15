package com.github.grizzly.repository;

import com.github.grizzly.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(long userId);

    Optional<User> findUserByPhone(String phone);

    Optional<User> findByEmail(String email);

    Optional<User> findByLogin(String login);

}

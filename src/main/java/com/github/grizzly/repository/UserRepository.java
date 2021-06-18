package com.github.grizzly.repository;

import com.github.grizzly.entity.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(@NonNull String login);

    Optional<User> findByEmail(@NonNull String email);

    Optional<User> findByPhone(@NonNull String phone);

    List<User> findByCreatedAtBefore(Date createdAt);

    List<User> findByCreatedAtAfter(Date createdAt);

    List<User> findByUpdatedAtBefore(Date updatedAt);

    List<User> findByUpdatedAtAfter(Date updatedAt);

    List<User> findByActive(User.Active active);

    List<User> findByVerification(User.Verification verification);

}

package com.example.mimicat.repository;

import com.example.mimicat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByLogin(String login);

    User findUserByFirstName(String name);
}

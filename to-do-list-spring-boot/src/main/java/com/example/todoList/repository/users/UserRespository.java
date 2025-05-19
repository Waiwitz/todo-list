package com.example.todoList.repository.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todoList.entity.User;

public interface UserRespository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}

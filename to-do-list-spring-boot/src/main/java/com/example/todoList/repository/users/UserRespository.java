package com.example.todoList.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todoList.entity.User;

public interface UserRespository extends JpaRepository<User, Integer>{
    User findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}

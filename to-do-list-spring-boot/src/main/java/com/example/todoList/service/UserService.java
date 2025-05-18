package com.example.todoList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Service;

import com.example.todoList.entity.User;
import com.example.todoList.repository.users.UserRespository;

@Service
@Configuration
@EnableJpaAuditing
public class UserService {
    @Autowired
    private UserRespository userRespository;

   public User saveUser(User user) {
    return userRespository.save(user);
   }

   public User getUserById(int id) {
    return userRespository.findById(id).orElse(null);
   }
}

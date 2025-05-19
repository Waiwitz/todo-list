package com.example.todoList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.todoList.dto.RegisterRequest;
import com.example.todoList.entity.User;
import com.example.todoList.repository.users.UserRespository;

@Service
@Configuration
@EnableJpaAuditing
public class UserService {
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRespository userRespository;

    public User registerUser(RegisterRequest registerRequest) {
        String hashedPassword = passwordEncoder.encode(registerRequest.getPassword());
        User user = new User(
                registerRequest.getUsername(),
                hashedPassword,
                registerRequest.getEmail(),
                registerRequest.getFirstName(),
                registerRequest.getLastName());
        return userRespository.save(user);
    }

    public Boolean loginPasswordCheck(String username, String password) {
        return userRespository.findByUsername(username)
                .map(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElse(false);

    }
    // public User saveUser(User user) {
    // return userRespository.save(user);
    // }

    // public User getUserById(int id) {
    // return userRespository.findById(id).orElse(null);
    // }
}

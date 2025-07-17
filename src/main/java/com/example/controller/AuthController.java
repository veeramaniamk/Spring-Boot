package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Users;
import com.example.repository.UsersRepository;

@RestController
public class AuthController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/dashboard")
    public String dashboardEndpoint() {
        return "Hello, from the DASHBOARD!";
    }

    @PostMapping("/create-user")
    public ResponseEntity<Map<String, Object>> createUser() {

        usersRepository.save(new Users("veeramani", "veeramaniamk@gmail.com"));

        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("message", "Users Created Successfully");
        ResponseEntity<Map<String, Object>> res = new ResponseEntity<>(map, HttpStatus.ACCEPTED);

        return res;
    }

    @GetMapping("/admin")
    public ResponseEntity<Void> adminEndpoint() {
        return ResponseEntity.status(302)
                .header("Location", "/dashboard")
                .build();
    }
    
}



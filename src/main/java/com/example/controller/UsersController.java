package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    UserService userService;

    @PostMapping
    private String createUser(@RequestParam String name,
                         @RequestParam String email) {

        if(userService.createUser(name, email)==null) {
            return "User Creation Failed";
        }

        return "welcome " + name;
    }

    @DeleteMapping("/{userId}")
    private String deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return "User Deleted";
    }
    
}

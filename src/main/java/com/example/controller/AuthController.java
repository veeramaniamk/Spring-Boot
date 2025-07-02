package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public page";
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "Hello, authenticated USER!";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Welcome ADMIN!";
    }

    
    
}

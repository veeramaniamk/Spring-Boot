package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/dashboard")
    public String dashboardEndpoint() {
        return "Hello, from the DASHBOARD!";
    }

    @GetMapping("/admin")
    public ResponseEntity<Void> adminEndpoint() {
        return ResponseEntity.status(302)
                .header("Location", "/dashboard")
                .build();
    }
    
}



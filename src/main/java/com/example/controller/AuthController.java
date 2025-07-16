package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
// import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.AuthException;

// import com.example.uril.Constance;

@RestController
public class AuthController {

    @GetMapping("/public")
    public String publicEndpoint() throws AuthException {
        throw new AuthException("For Testing");
        // return "This is a public page";
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "Hello, authenticated USER!";
    }

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

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to the Home Page!");
        return "${appName}"; // Return view name (home.html)
    }
    
}

package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.exception.AuthException;

@Controller
public class ForControle {
    
    @GetMapping("/hi")
    public String hiFun() throws AuthException {
        throw new AuthException("hi fun throws exception");
    }
    
}

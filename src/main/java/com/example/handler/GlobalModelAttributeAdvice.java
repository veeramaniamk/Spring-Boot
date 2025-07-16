package com.example.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttributeAdvice {
 
    @ModelAttribute
    public void addGlobalAttributes(Model model) {
        model.addAttribute("appName", "My Spring Boot App");
    }

}

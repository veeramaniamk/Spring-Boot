package com.example.component.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.util.Constance;

// import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanBractice {
    
    @Bean("a")
    public String someStringValue2() {
       Constance.println("someStringValue2 fun call from BeanBractice");
       return "ad";
    }
    
}

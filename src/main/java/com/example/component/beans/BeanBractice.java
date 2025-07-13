package com.example.component.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.example.uril.Constance;

// import org.springframework.context.annotation.Configuration;

@Configuration
@Order(2)
public class BeanBractice {
    
    @Bean("a")
    public String someStringValue2() {
       Constance.println("someStringValue2 fun call from BeanBractice");
       return "ad";
    }
    
}

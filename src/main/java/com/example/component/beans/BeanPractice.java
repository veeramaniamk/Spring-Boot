package com.example.component.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.uril.Constance;

// import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPractice {
    
    
    public BeanPractice() {
       Constance.println("BeanPractice Empty Constructor Called");
    }

    public BeanPractice(String s) {
       Constance.println(s);
    }

    @Bean
    public String setMaping() {
       Constance.println("setMaping ");
       return "ad";
    }
    
}

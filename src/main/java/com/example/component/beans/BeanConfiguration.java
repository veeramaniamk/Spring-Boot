package com.example.component.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.util.Constance;

@Configuration
public class BeanConfiguration {

    @Bean("value2")
    public String getBeanConfig( String someStringValue) {
       Constance.println("getBeanConfig fun call from BeanConfiguration");
        return "value";
    }
    
}

package com.example.component.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.example.uril.Constance;

@Configuration
@Order(1)
public class BeanConfiguration {

    @Bean("value2")
    public String getBeanConfig( String someStringValue) {
       Constance.println("getBeanConfig fun call from BeanConfiguration");
        return "value";
    }
    
}

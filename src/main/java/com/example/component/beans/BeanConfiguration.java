package com.example.component.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfiguration {


    @Bean
    @Qualifier("value2")
    public String someStringValue2() {
        return "Hello Bean value2";
    }

    @Bean
    public String someStringValu() {
        return "Hello Bean";
    }
    
    @Bean("value2")
    public BeanPractice getBeanConfig(@Qualifier("value2") String someStringValue) {
        return new BeanPractice(someStringValue);
    }
    
}

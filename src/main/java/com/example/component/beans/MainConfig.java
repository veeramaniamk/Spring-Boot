package com.example.component.beans;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({BeanConfiguration.class, BeanBractice.class})
public class MainConfig {
    
}

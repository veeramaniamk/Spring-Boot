package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.component.Practice;

/**
 * Hello world!
 */

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context  = SpringApplication.run(App.class, args);

       Practice cs = context.getBean(Practice.class);
        cs.build();
    }
}

package com.example.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class SecondTestComponent implements ImplementComponent{

    public void compile() {
        System.out.println("SecondTestComponent");
    }
}
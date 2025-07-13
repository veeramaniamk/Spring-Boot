package com.example.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Practice {

    @Autowired
    TestComponent imp;
    
    public void build() {

        imp.compile();

    }

}



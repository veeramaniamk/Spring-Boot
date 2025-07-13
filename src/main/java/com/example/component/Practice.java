package com.example.component;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Practice {

    @Autowired
    TestComponent imp;
    
    public void build() {

        imp.compile();

    }

}



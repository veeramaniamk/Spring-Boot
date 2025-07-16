package com.example.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exception.AuthException;

@ControllerAdvice(assignableTypes = AuthException.class)
public class SpecificExceptionHanlder {
    
    @ExceptionHandler(AuthException.class) 
    public ResponseEntity<Map<String, String>> authExceptionHandler(AuthException e) {
        System.out.println("AuthException handler called");
        Map<String, String> map = new HashMap<>();

        map.put("status", "500");
        map.put("message", e.getMessage());
        ResponseEntity<Map<String, String>> res = new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        return res;
    }

}


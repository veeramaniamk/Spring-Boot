package com.example.exception;


public class AuthException extends RuntimeException { 

    public AuthException(String msg) {
        super(msg);
    }
    
}

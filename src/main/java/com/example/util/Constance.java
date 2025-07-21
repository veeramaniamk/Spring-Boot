package com.example.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Constance {
    

    public static void println(String value) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";
        // String ANSI_BLUE = "\u001B[34m";
        // String ANSI_RED = "\u001B[31m";

        System.out.println(ANSI_GREEN + value + ANSI_RESET);
    }

    public static ResponseEntity<Map<String, Object>> getResponseEntity(int statusCode, String message, HttpStatus responseCode) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", statusCode);
        map.put("message", message);
        ResponseEntity<Map<String, Object>> data = new ResponseEntity<>(map, responseCode);
        return data;
    }

}

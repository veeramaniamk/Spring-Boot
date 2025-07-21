package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Users;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    UserService userService;

    @PostMapping
    private String createUser(@RequestParam String name,
                         @RequestParam String email) {

        if(userService.createUser(name, email)==null) {
            return "User Creation Failed";
        }

        return "welcome " + name;
    }

    @DeleteMapping("/{userId}")
    private String deleteUser(@PathVariable Long userId) {
        if(userService.deleteUser(userId)==0) {
            return "User Not Found";
        }
        return "User Deleted";
    }

    @PutMapping("/{userId}")
    private ResponseEntity<Map<String, Object>> updateUser(@PathVariable long userId, @RequestBody Users user) {


        Map<String, Object> resData = new HashMap<>();

        if(user.getName() == null || user.getName()==null) {
            resData.put("status", 400);
            resData.put("message", "Bad Request");
            return new ResponseEntity<>(resData, HttpStatus.BAD_REQUEST);
        }

        boolean isUpdated = userService.updateUser(userId, user);

        if(isUpdated) {
            resData.put("status", 200);
            resData.put("message", "User Updated Successfully");
            return new ResponseEntity<>(resData, HttpStatus.OK);
        } else {
            resData.put("status", 404);
            resData.put("message", "User Not Found");
            return new ResponseEntity<>(resData, HttpStatus.NOT_FOUND);
        }
        
    }
    
}

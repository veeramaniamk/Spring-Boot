package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Users;
import com.example.repository.UsersRepository;

@Service
public class UserService {
    
    @Autowired
    UsersRepository usersRepository;

    public Users createUser(String name, String email) {
        return usersRepository.save(new Users(name, email));
    }

    public int deleteUser(long userId) {
        return usersRepository.deleteUserById(userId);
    }

    public void updateUser(long userId) {
        
    }

}

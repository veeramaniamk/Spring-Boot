package com.example.service;

import java.util.List;

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

    public boolean updateUser(long userId, Users user) {
        return 0<usersRepository.updateUserById(userId, user.getName(), user.getEmail());
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

}

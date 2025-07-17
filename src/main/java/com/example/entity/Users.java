package com.example.entity;

import jakarta.persistence.Entity;

@Entity
public class Users {

    private int id;
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

}
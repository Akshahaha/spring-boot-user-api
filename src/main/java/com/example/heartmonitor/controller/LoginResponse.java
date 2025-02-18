package com.example.heartmonitor.controller;

import com.example.heartmonitor.model.User;

public class LoginResponse {
    private String message;
    private User user; // Or just the user ID or other info

    // Constructors, getters, and setters
    public LoginResponse() {
    }

    public LoginResponse(String message, User user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
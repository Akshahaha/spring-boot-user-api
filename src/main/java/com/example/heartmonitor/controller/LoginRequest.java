package com.example.heartmonitor.controller;  // Ensure the package is correct!

public class LoginRequest {
    private String email;
    private String password;

    // Default constructor (required for Jackson)
    public LoginRequest() {
    }

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
package com.example.heartmonitor.controller; // Make sure the package is correct

public class RegistrationRequest {
    private String email;
    private String password;

    // Default constructor (required for Jackson)
    public RegistrationRequest() {
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
package com.example.heartmonitor.controller;

import com.example.heartmonitor.model.User;
import com.example.heartmonitor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public User register(@RequestBody RegistrationRequest request) {
        return userService.registerUser(request.getEmail(), request.getPassword());
    }

    @PostMapping("/login")
    @ResponseBody
    public LoginResponse login(@RequestBody LoginRequest request) {
        User user = userService.loginUser(request.getEmail(), request.getPassword());
        if (user != null) {
            return new LoginResponse("Login successful", user);
        } else {
            throw new LoginFailedException("Invalid email or password");
        }
    }

    // Custom exception class
    @ResponseStatus(HttpStatus.UNAUTHORIZED)  // Sets the HTTP status code to 401
    static class LoginFailedException extends RuntimeException { //Made static so it can be used in the controller
        public LoginFailedException(String message) {
            super(message);
        }
    }

    // Custom error response class
    static class ErrorResponse {  //Made static so it can be used in the controller
        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    // Exception handler for LoginFailedException
    @ExceptionHandler(LoginFailedException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleLoginFailedException(LoginFailedException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED); // Explicitly set status code
    }
}
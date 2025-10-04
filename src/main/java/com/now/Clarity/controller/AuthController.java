package com.now.Clarity.controller;

import com.now.Clarity.dto.LoginRequestDto;
import com.now.Clarity.dto.UserRegistrationDto;
import com.now.Clarity.model.User;
import com.now.Clarity.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * POST /api/auth/register
     * Registers a new user.
     * Returns 201 Created on success, 409 Conflict if username exists.
     */
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegistrationDto registrationDto) {
        try {
            // Service handles hashing and saving
            User newUser = userService.registerUser(registrationDto);
            return new ResponseEntity<>("User registered successfully. ID: " + newUser.getId(), HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            // Handles 'Username already taken.' exception thrown by the UserService
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    /**
     * POST /api/auth/login
     * Basic verification of user credentials against the stored hash.
     * Returns 200 OK on success, 401 Unauthorized on failure.
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginDto) {
        // 1. Find user by username
        return userService.findByUsername(loginDto.getUsername())
                .map(user -> {
                    // 2. Verify password hash using the PasswordEncoder
                    if (passwordEncoder.matches(loginDto.getPassword(), user.getPasswordHash())) {
                        // SUCCESS: Credentials match
                        return ResponseEntity.ok("Login successful (Basic verification).");
                    } else {
                        // FAILURE: Password mismatch
                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
                    }
                })
                .orElseGet(() ->
                        // FAILURE: User not found
                        ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.")
                );
    }
}
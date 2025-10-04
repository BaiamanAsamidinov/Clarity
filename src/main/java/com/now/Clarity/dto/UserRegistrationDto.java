package com.now.Clarity.dto;

public class UserRegistrationDto {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // --- Also good practice to add Setters and a no-arg constructor (for JSON mapping) ---

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRegistrationDto() {
        // Required for Spring/Jackson JSON deserialization
    }
}

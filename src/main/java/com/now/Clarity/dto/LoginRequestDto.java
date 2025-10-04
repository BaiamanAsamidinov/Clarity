package com.now.Clarity.dto;

public class LoginRequestDto {
    private String username;
    private String password;

    // Required for Spring/Jackson to map JSON requests
    public LoginRequestDto() {}

    // --- Add the required Getter Methods ---

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // --- Also good practice to add Setters if needed, for completeness ---

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
package com.now.Clarity.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String passwordHash; // Stores the secure hash, not plain password

    // Getters and Setters (omitted for brevity)
    // No-arg and all-arg constructors (omitted for brevity)
}

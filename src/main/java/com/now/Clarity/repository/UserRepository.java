package com.now.Clarity.repository;

import com.now.Clarity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Optional, but good practice
public interface UserRepository extends JpaRepository<User, Long> {

    // Spring Data JPA automatically provides basic CRUD operations:
    // save(), findById(), findAll(), deleteById(), etc.

    // You can also define custom finder methods here, e.g.:
    Optional<User> findByUsername(String username);
}

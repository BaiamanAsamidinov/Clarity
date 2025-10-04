package com.now.Clarity.service.impl;

import com.now.Clarity.dto.UserRegistrationDto;
import com.now.Clarity.model.User;
import com.now.Clarity.repository.UserRepository;
import com.now.Clarity.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(UserRegistrationDto registrationDto) {

        if (userRepository.findByUsername(registrationDto.getUsername()).isPresent()) {
            throw new IllegalStateException("Username already taken.");
        }

        //Hash the plain-text password
        String hashedPassword = passwordEncoder.encode(registrationDto.getPassword());

        //Create the new User entity
        User newUser = new User();
        newUser.setUsername(registrationDto.getUsername());
        newUser.setPasswordHash(hashedPassword); //Store the Hash

        //Save the database
        return userRepository.save(newUser);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

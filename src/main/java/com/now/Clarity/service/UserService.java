package com.now.Clarity.service;

import com.now.Clarity.dto.UserRegistrationDto;
import com.now.Clarity.model.User;
import java.util.Optional;

public interface UserService {
    User registerUser(UserRegistrationDto registrationDto);

    Optional<User> findByUsername(String username);
}

package com.example.booking.service;

import com.example.booking.domain.User;
import com.example.booking.exception.BadNameException;
import com.example.booking.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        validateUser(user);
        return userRepository.save(user);
    }

    public void validateUser(User user) {
        if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
            throw new BadNameException("firstName", "First name cannot be empty");
        }

        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            throw new BadNameException("lastName", "Last name cannot be empty");
        }
    }
}

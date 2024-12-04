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

        return userRepository.save(user);
    }


}

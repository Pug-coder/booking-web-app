package com.example.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.booking.domain.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}

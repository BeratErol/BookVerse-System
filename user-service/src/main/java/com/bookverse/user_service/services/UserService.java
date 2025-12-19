package com.bookverse.user_service.services;

import java.util.List;
import java.util.Optional;

import com.bookverse.user_service.entities.User;

// Kullanıcı iş mantığı arayüzü
public interface UserService {
    Optional<User> findUserById(int id);
    List<User> findAllUsers();
}
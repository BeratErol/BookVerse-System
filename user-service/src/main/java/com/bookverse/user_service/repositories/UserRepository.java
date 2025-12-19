package com.bookverse.user_service.repositories;

import java.util.List;
import java.util.Optional;

import com.bookverse.user_service.entities.User;

// Kullanıcı veri erişimi arayüzü
public interface UserRepository {
    Optional<User> findById(int id);
    List<User> findAll();
}
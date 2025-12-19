package com.bookverse.user_service.repositories;

import org.springframework.stereotype.Repository;

import com.bookverse.user_service.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryUserRepository implements UserRepository {

    // Geçici veri kaynağı (şimdilik)
    private static final List<User> users = new ArrayList<>();
    
    static {
        users.add(new User(101, "Alice Smith"));
        users.add(new User(102, "Bob Johnson"));
        users.add(new User(103, "Charlie Brown"));
    }

    @Override
    public Optional<User> findById(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
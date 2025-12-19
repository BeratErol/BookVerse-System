package com.bookverse.user_service.services;

import com.bookverse.user_service.entities.User;
import com.bookverse.user_service.repositories.UserRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserById(int id) {
        // Basit iş mantığı (BookService'deki gibi)
        if (id <= 0) {
            throw new IllegalArgumentException("Kullanıcı ID'si pozitif bir değer olmalıdır.");
        }
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
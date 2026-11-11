package com.bank.auth.application.service;

import com.bank.auth.domain.model.User;
import com.bank.auth.domain.ports.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String authenticate(String username, String password) {
        throw new UnsupportedOperationException("Implementar autenticación con validación de credenciales");
    }

    public String refreshToken(String token) {
        throw new UnsupportedOperationException("Implementar renovación de token JWT");
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findUserById(UUID id) {
        return userRepository.findById(id);
    }
}
package com.bank.auth.infrastructure.controllers;

import com.bank.auth.application.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        throw new UnsupportedOperationException("Implementar endpoint de login que valide credenciales y retorne JWT");
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody Map<String, String> request) {
        throw new UnsupportedOperationException("Implementar endpoint de refresh que renueve el token");
    }
}
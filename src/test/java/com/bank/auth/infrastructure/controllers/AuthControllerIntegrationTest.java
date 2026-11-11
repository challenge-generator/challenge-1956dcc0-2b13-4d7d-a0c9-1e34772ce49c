package com.bank.auth.infrastructure.controllers;


import com.bank.auth.domain.model.User;
import com.bank.auth.application.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@WebMvcTest(AuthController.class)
@DisplayName("Pruebas de integración para AuthController")
class AuthControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuthService authService;

    private Map<String, String> loginRequest;
    private Map<String, String> registerRequest;

    @BeforeEach
    void setUp() {
        loginRequest = Map.of(
            "username", "testuser",
            "password", "SecurePass123!"
        );
        
        registerRequest = Map.of(
            "username", "newuser",
            "password", "NewPass123!",
            "email", "newuser@bank.com"
        );
    }

    @Test
    @DisplayName("POST /auth/login - Login exitoso con credenciales válidas")
    void login_WithValidCredentials_Returns200AndToken() throws Exception {
        // Given: credenciales válidas
        String expectedToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0dXNlciJ9.signature";
        when(authService.login(anyString(), anyString())).thenReturn(expectedToken);
        
        // When: se envía request de login
        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
        
        // Then: verificar respuesta 200 con token
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.token").value(expectedToken));
    }

    @Test
    @DisplayName("POST /auth/login - Login fallido con credenciales inválidas")
    void login_WithInvalidCredentials_Returns401() throws Exception {
        // Given: credenciales inválidas
        when(authService.login(anyString(), anyString()))
            .thenThrow(new RuntimeException("Invalid credentials"));
        
        // When: se envía request de login
        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
        
        // Then: verificar respuesta 401
        .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("POST /auth/login - Login con request malformado retorna 400")
    void login_WithMalformedRequest_Returns400() throws Exception {
        // Given: request sin campos obligatorios
        Map<String, String> malformedRequest = Map.of("username", "testuser");
        
        // When: se envía request malformado
        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(malformedRequest)))
        
        // Then: verificar respuesta 400
        .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /auth/register - Registro exitoso")
    void register_WithValidData_Returns201() throws Exception {
        // Given: datos de registro válidos
        when(authService.register(anyString(), anyString(), anyString()))
            .thenReturn("User created successfully");
        
        // When: se envía request de registro
        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerRequest)))
        
        // Then: verificar respuesta 201
        .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("POST /auth/register - Registro con username duplicado retorna 409")
    void register_WithDuplicateUsername_Returns409() throws Exception {
        // Given: username ya existe
        when(authService.register(anyString(), anyString(), anyString()))
            .thenThrow(new RuntimeException("Username already exists"));
        
        // When: se envía request de registro
        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerRequest)))
        
        // Then: verificar respuesta 409
        .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("POST /auth/register - Registro con email duplicado retorna 409")
    void register_WithDuplicateEmail_Returns409() throws Exception {
        // Given: email ya existe
        when(authService.register(anyString(), anyString(), anyString()))
            .thenThrow(new RuntimeException("Email already exists"));
        
        // When: se envía request de registro
        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerRequest)))
        
        // Then: verificar respuesta 409
        .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("POST /auth/register - Registro con password débil retorna 400")
    void register_WithWeakPassword_Returns400() throws Exception {
        // Given: password que no cumple requisitos
        Map<String, String> weakPasswordRequest = Map.of(
            "username", "newuser",
            "password", "weak",
            "email", "newuser@bank.com"
        );
        
        // When: se envía request con password débil
        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(weakPasswordRequest)))
        
        // Then: verificar respuesta 400
        .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /auth/register - Registro con email inválido retorna 400")
    void register_WithInvalidEmail_Returns400() throws Exception {
        // Given: email con formato inválido
        Map<String, String> invalidEmailRequest = Map.of(
            "username", "newuser",
            "password", "NewPass123!",
            "email", "invalid-email"
        );
        
        // When: se envía request con email inválido
        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidEmailRequest)))
        
        // Then: verificar respuesta 400
        .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /auth/refresh - Renovación de token exitosa")
    void refreshToken_WithValidToken_Returns200() throws Exception {
        // Given: token de renovación válido
        String refreshToken = "refresh.token.here";
        String newAccessToken = "new.access.token";
        
        when(authService.refreshToken(anyString())).thenReturn(newAccessToken);
        
        // When: se envía request de renovación
        mockMvc.perform(post("/auth/refresh")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Map.of("refreshToken", refreshToken))))
        
        // Then: verificar respuesta 200 con nuevo token
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.token").value(newAccessToken));
    }

    @Test
    @DisplayName("POST /auth/refresh - Renovación con token inválido retorna 401")
    void refreshToken_WithInvalidToken_Returns401() throws Exception {
        // Given: token de renovación inválido
        when(authService.refreshToken(anyString()))
            .thenThrow(new RuntimeException("Invalid refresh token"));
        
        // When: se envía request de renovación
        mockMvc.perform(post("/auth/refresh")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Map.of("refreshToken", "invalid"))))
        
        // Then: verificar respuesta 401
        .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("GET /auth/status - Verificación de estado de autenticación")
    void status_AuthenticatedUser_Returns200() throws Exception {
        // Given: usuario autenticado (header con token)
        // TODO: Configurar autenticación en el contexto de seguridad
        
        // When: se verifica el estado
        mockMvc.perform(get("/auth/status"))
        
        // Then: verificar respuesta 200 con información del usuario
        // TODO: Implementar assertions
    }

    @Test
    @DisplayName("GET /auth/status - Sin autenticación retorna 401")
    void status_UnauthenticatedUser_Returns401() throws Exception {
        // Given: request sin autenticación
        
        // When: se verifica el estado
        mockMvc.perform(get("/auth/status"))
        
        // Then: verificar respuesta 401
        .andExpect(status().isUnauthorized());
    }
}
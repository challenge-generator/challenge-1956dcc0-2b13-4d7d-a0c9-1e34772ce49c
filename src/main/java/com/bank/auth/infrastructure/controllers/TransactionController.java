package com.bank.auth.infrastructure.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @GetMapping("/balance")
    public ResponseEntity<?> getBalance() {
        throw new UnsupportedOperationException("Implementar endpoint protegido que retorne el saldo del usuario autenticado");
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestBody Map<String, Object> transferRequest) {
        throw new UnsupportedOperationException("Implementar endpoint protegido para realizar transferencias");
    }

    @GetMapping("/history")
    public ResponseEntity<?> getTransactionHistory() {
        throw new UnsupportedOperationException("Implementar endpoint protegido que retorne el historial de transacciones");
    }
}
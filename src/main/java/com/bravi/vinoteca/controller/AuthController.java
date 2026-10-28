package com.bravi.vinoteca.controller;

import com.bravi.vinoteca.config.constant.Endpoints;
import com.bravi.vinoteca.dto.AuthResponse;
import com.bravi.vinoteca.dto.LoginRequest;
import com.bravi.vinoteca.dto.RegisterRequest;
import com.bravi.vinoteca.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(Endpoints.AUTH)
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    @PostMapping(Endpoints.REGISTER)
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        AuthResponse response = authService.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping(Endpoints.LOGIN)
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getCurrentUser() {
        return ResponseEntity.ok(Map.of(
                "message", "Autenticación funcionando"
        ));
    }
}

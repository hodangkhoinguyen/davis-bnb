package com.example.nguyenho.davisbnb.controller;

import com.example.nguyenho.davisbnb.payload.request.LoginRequest;
import com.example.nguyenho.davisbnb.payload.request.RegisterRequest;
import com.example.nguyenho.davisbnb.payload.response.JwtResponse;
import com.example.nguyenho.davisbnb.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        logger.info("Register {}", request);
        return authService.registerUser(request);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticate(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.authenticateUser(request));
    }
}

package com.skillbridge.service.impl;

import org.springframework.stereotype.Service;

import com.skillbridge.dto.AuthResponse;
import com.skillbridge.dto.LoginRequest;
import com.skillbridge.dto.RegisterRequest;
import com.skillbridge.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthResponse register(RegisterRequest request) {

        return AuthResponse.builder()
                .message("User Registered Successfully")
                .token("")
                .build();
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        return AuthResponse.builder()
                .message("Login Successful")
                .token("")
                .build();
    }
}
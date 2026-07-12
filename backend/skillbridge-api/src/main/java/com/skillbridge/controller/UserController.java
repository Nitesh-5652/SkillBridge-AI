package com.skillbridge.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillbridge.dto.ChangePasswordRequest;
import com.skillbridge.dto.UpdateUserRequest;
import com.skillbridge.dto.UserResponse;
import com.skillbridge.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public UserResponse me(Authentication authentication) {
        return userService.getCurrentUser(authentication.getName());
    }

    @PutMapping("/me")
    public UserResponse updateMe(
            Authentication authentication,
            @RequestBody UpdateUserRequest request) {

        return userService.updateCurrentUser(
                authentication.getName(),
                request);
    }

    @PatchMapping("/change-password")
    public String changePassword(
            Authentication authentication,
            @RequestBody ChangePasswordRequest request) {

        userService.changePassword(authentication.getName(), request);
        return "Password changed successfully";
    }
}

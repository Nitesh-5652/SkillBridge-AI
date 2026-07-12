package com.skillbridge.service;

import com.skillbridge.dto.ChangePasswordRequest;
import com.skillbridge.dto.UpdateUserRequest;
import com.skillbridge.dto.UserResponse;

public interface UserService {

    UserResponse getCurrentUser(String email);

    UserResponse updateCurrentUser(String email, UpdateUserRequest request);

    void changePassword(String email, ChangePasswordRequest request);

}

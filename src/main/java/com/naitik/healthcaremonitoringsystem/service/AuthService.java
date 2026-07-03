package com.naitik.healthcaremonitoringsystem.service;

import com.naitik.healthcaremonitoringsystem.dto.AuthResponse;
import com.naitik.healthcaremonitoringsystem.dto.LoginRequest;

public interface AuthService {

    AuthResponse login(LoginRequest request);

}
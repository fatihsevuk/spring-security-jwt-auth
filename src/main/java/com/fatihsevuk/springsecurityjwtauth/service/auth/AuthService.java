package com.fatihsevuk.springsecurityjwtauth.service.auth;

import com.fatihsevuk.springsecurityjwtauth.model.auth.AuthRequest;
import com.fatihsevuk.springsecurityjwtauth.model.auth.AuthResponse;
import com.fatihsevuk.springsecurityjwtauth.model.auth.RefreshTokenRequest;

public interface AuthService {

    AuthResponse authenticate(AuthRequest authRequest);
    AuthResponse refreshToken(RefreshTokenRequest request);
}

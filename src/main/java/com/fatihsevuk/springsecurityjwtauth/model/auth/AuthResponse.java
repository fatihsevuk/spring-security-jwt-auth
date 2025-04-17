package com.fatihsevuk.springsecurityjwtauth.model.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
@Data
public class AuthResponse {

    private String accessToken;
    private String refreshToken;
    private String username;
    private List<String> roles;

}


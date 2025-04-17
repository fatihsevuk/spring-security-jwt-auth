package com.fatihsevuk.springsecurityjwtauth.service.auth;


import com.fatihsevuk.springsecurityjwtauth.entity.User;
import com.fatihsevuk.springsecurityjwtauth.model.auth.AuthRequest;
import com.fatihsevuk.springsecurityjwtauth.model.auth.AuthResponse;
import com.fatihsevuk.springsecurityjwtauth.model.auth.RefreshTokenRequest;
import com.fatihsevuk.springsecurityjwtauth.security.JwtUtils;
import com.fatihsevuk.springsecurityjwtauth.service.UserDetailService;
import com.fatihsevuk.springsecurityjwtauth.util.exception.InvalidTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserDetailService userDetailService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(), authRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
            User userDetails = (User) authentication.getPrincipal();

        String accessToken = jwtUtils.generateToken(userDetails);
        String refreshToken = jwtUtils.generateRefreshToken(userDetails);

        //revokeAllUserTokens(userDetails.getId());
        //saveUserToken(userDetails.getUser(), accessToken);

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .username(userDetails.getUsername())
                .roles(userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .toList())
                .build();


    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest request) {
        String refreshToken = request.getRefreshToken();
        String username = jwtUtils.extractUsername(refreshToken);

        if (username != null) {
            User userDetails = (User) userDetailService.loadUserByUsername(username);
            if (jwtUtils.isTokenValid(refreshToken, userDetails)) {
                String accessToken = jwtUtils.generateToken(userDetails);

                //revokeAllUserTokens(userDetails.getId());
                //saveUserToken(userDetails.getUser(), accessToken);

                return AuthResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .username(userDetails.getUsername())
                        .roles(userDetails.getAuthorities().stream()
                                .map(GrantedAuthority::getAuthority)
                                .toList())
                        .build();
            } else {
                throw new InvalidTokenException("Invalid refresh token");

            }
        } else {
            throw new InvalidTokenException("Invalid refresh token");

        }
    }

}

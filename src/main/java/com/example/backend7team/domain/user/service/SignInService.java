package com.example.backend7team.domain.user.service;

import com.example.backend7team.domain.user.domain.User;
import com.example.backend7team.domain.user.domain.repository.UserRepository;
import com.example.backend7team.domain.user.exception.InvalidPasswordException;
import com.example.backend7team.domain.user.exception.UserNotFoundException;
import com.example.backend7team.domain.user.presentation.dto.request.SignInRequest;
import com.example.backend7team.domain.user.presentation.dto.response.SignInResponse;
import com.example.backend7team.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignInService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public SignInResponse execute(SignInRequest request) {
        User user = userRepository.queryUserByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw InvalidPasswordException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(user.getAccountId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getAccountId());

        return SignInResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}

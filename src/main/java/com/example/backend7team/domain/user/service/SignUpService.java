package com.example.backend7team.domain.user.service;

import com.example.backend7team.domain.user.domain.User;
import com.example.backend7team.domain.user.domain.repository.UserRepository;
import com.example.backend7team.domain.user.exception.UserAlreadyExistsException;
import com.example.backend7team.domain.user.presentation.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignUpRequest request) {
        if (userRepository.existsUserByAccountId(request.getAccountId())) {
            throw UserAlreadyExistsException.EXCEPTION;
        }

        userRepository.saveUser(
                User.builder()
                        .accountId(request.getAccountId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .name(request.getName())
                        .build()
        );
    }
}

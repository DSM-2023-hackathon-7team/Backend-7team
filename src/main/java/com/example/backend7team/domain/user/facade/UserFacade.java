package com.example.backend7team.domain.user.facade;

import com.example.backend7team.domain.user.domain.User;
import com.example.backend7team.domain.user.domain.repository.UserRepository;
import com.example.backend7team.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(accountId);
        return userRepository.queryUserByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}

package com.example.backend7team.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignInResponse {

    private final String accessToken;
    private final String refreshToken;
}

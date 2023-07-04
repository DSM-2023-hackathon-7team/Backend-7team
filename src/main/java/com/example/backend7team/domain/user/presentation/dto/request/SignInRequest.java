package com.example.backend7team.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class SignInRequest {

    @NotBlank
    @Size(max = 20)
    private String accountId;

    @NotBlank
    @Size(max = 30)
    private String password;
}

package com.example.backend7team.domain.user.presentation;

import com.example.backend7team.domain.user.presentation.dto.request.SignInRequest;
import com.example.backend7team.domain.user.presentation.dto.request.SignUpRequest;
import com.example.backend7team.domain.user.presentation.dto.response.SignInResponse;
import com.example.backend7team.domain.user.service.SignInService;
import com.example.backend7team.domain.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final SignUpService signUpService;
    private final SignInService signInService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid SignUpRequest request) {
        signUpService.execute(request);
    }

    @PostMapping("/signin")
    public SignInResponse signin(@RequestBody @Valid SignInRequest request) {
        return signInService.execute(request);
    }
}

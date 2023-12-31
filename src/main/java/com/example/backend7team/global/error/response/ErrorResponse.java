package com.example.backend7team.global.error.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final Integer status;
    private final String message;
}

package com.example.backend7team.domain.user.exception;

import com.example.backend7team.global.error.exception.CustomException;
import com.example.backend7team.global.error.exception.ErrorCode;

public class InvalidPasswordException extends CustomException {

    public static final CustomException EXCEPTION = new InvalidPasswordException();

    private InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}

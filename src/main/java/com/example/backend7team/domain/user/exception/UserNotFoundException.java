package com.example.backend7team.domain.user.exception;

import com.example.backend7team.global.error.exception.CustomException;
import com.example.backend7team.global.error.exception.ErrorCode;

public class UserNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}

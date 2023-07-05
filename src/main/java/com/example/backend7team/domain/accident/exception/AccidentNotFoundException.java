package com.example.backend7team.domain.accident.exception;

import com.example.backend7team.global.error.exception.CustomException;
import com.example.backend7team.global.error.exception.ErrorCode;

public class AccidentNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new AccidentNotFoundException();

    private AccidentNotFoundException() {
        super(ErrorCode.ACCIDENT_NOT_FOUND);
    }
}

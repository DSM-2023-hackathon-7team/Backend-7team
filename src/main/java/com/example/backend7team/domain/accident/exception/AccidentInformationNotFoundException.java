package com.example.backend7team.domain.accident.exception;

import com.example.backend7team.global.error.exception.CustomException;
import com.example.backend7team.global.error.exception.ErrorCode;

public class AccidentInformationNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new AccidentInformationNotFoundException();

    private AccidentInformationNotFoundException() {
        super(ErrorCode.ACCIDENT_INFORMATION_NOT_FOUND);
    }
}

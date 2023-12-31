package com.example.backend7team.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    FILE_UPLOAD_FAILED(400, "File Upload Failed"),

    EXPIRED_TOKEN(401, "Token Expired"),
    INVALID_TOKEN(401, "Invalid Token"),
    INVALID_PASSWORD(401, "Invalid Password"),

    USER_NOT_FOUND(404, "User Not Found"),
    ACCIDENT_NOT_FOUND(404, "Accident Not Found"),
    ACCIDENT_INFORMATION_NOT_FOUND(404, "Accident Information Not Found"),

    USER_ALREADY_EXISTS(409, "User Already Exists");

    private final Integer status;
    private final String message;
}

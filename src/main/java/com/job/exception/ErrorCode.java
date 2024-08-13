package com.job.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // Common
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Not Found"),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error"),

    // Users
    ALREADY_APPLY(HttpStatus.BAD_REQUEST, "이미 지원한 공고입니다.");

    private final HttpStatus status;
    private final String message;
}

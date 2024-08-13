package com.job.exception;

import com.job.exception.dto.ExceptionResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ExceptionResponseDto> handlerCustomException(CustomException exception) {
        final ErrorCode errorCode = exception.getErrorCode();
        log.error("errorCode: {}, message: {}", errorCode.getStatus(), errorCode.getMessage());
        return ResponseEntity.status(errorCode.getStatus()).body(new ExceptionResponseDto(errorCode.getStatus().value(), errorCode.getMessage()));
    }

}
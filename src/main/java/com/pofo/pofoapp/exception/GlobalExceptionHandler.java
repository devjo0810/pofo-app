package com.pofo.pofoapp.exception;

import com.pofo.pofoapp.exception.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.pofo.pofoapp.exception.type.ErrorType.*;

/**
 * packageName    : com.pofo.pofoapp.exception
 * fileName       : GlobalExceptionHandler
 * author         : joyousang
 * date           : 2023/05/31
 * description    :
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity<ErrorResponse> handleValidateException(Exception e) {
        log.error("handleValidateException", e.getCause());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse<>(VALIDATION));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("handleException", e.getCause());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse<>(NO_HANDLING));
    }
}

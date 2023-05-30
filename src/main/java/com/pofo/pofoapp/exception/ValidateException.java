package com.pofo.pofoapp.exception;

/**
 * packageName    : com.pofo.pofoapp.exception
 * fileName       : ValidateDuplicateException
 * author         : joyousang
 * date           : 2023/05/30
 * description    :
 */
public class ValidateException extends RuntimeException {
    public ValidateException() {
    }

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateException(Throwable cause) {
        super(cause);
    }
}

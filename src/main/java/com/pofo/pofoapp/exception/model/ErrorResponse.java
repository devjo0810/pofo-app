package com.pofo.pofoapp.exception.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pofo.pofoapp.exception.type.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * packageName    : com.pofo.pofoapp.exception.model
 * fileName       : ErrorResponse
 * author         : joyousang
 * date           : 2023/05/31
 * description    :
 */
@Data
public class ErrorResponse<T> {
    private String code;
    private String message;
    @JsonInclude
    private T data;

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ErrorResponse(ErrorType errorType) {
        this.code = errorType.getCode();
        this.message = errorType.getMessage();
    }
}

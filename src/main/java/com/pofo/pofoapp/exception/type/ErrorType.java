package com.pofo.pofoapp.exception.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * packageName    : com.pofo.pofoapp.exception.type
 * fileName       : ErrorType
 * author         : joyousang
 * date           : 2023/05/31
 * description    :
 */
@Getter
@AllArgsConstructor
public enum ErrorType {
    VALIDATION("E.01.01", "유효하지 않는 값이 존재합니다."),
    NO_HANDLING("E.99.99", "알 수 없는 오류가 발생하였습니다.");

    private String code;
    private String message;

}

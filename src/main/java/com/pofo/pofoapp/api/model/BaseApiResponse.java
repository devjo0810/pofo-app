package com.pofo.pofoapp.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName    : com.pofo.pofoapp.api
 * fileName       : BaseApiResponse
 * author         : joyousang
 * date           : 2023/05/31
 * description    :
 */
@Data
@AllArgsConstructor
public class BaseApiResponse<T> {
    private T data;
}

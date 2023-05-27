package com.pofo.pofoapp.domain.common;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * packageName    : com.pofo.pofoapp.domain.common
 * fileName       : BaseEntity
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
@MappedSuperclass
public class BaseEntity {
    private Long createdBy;
    @CreatedDate
    private LocalDateTime createdAt;
    private Long modifiedBy;
    @LastModifiedDate
    private LocalDateTime modifiedAt;
}

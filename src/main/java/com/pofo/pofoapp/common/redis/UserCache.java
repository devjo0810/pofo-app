package com.pofo.pofoapp.common.redis;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * packageName    : com.pofo.pofoapp.common.redis
 * fileName       : UserCache
 * author         : joyousang
 * date           : 2023/05/28
 * description    :
 */
@RedisHash("users")
@Builder
public class UserCache {

    @Id
    private String jwt;
    private Long userId;
    private String name;
    private String email;

}

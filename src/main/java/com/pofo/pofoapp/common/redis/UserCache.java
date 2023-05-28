package com.pofo.pofoapp.common.redis;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

/**
 * packageName    : com.pofo.pofoapp.common.redis
 * fileName       : UserCache
 * author         : joyousang
 * date           : 2023/05/28
 * description    :
 */
@RedisHash(value = "user-token", timeToLive = 8640L) // 24h
@Builder
@Getter
public class UserCache {
    @Id
    private Long userId;
    private String token;
    private String name;
    private String email;

}

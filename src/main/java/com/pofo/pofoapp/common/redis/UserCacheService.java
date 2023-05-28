package com.pofo.pofoapp.common.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.pofo.pofoapp.common.redis
 * fileName       : RedisService
 * author         : joyousang
 * date           : 2023/05/28
 * description    :
 */
@Service
@RequiredArgsConstructor
public class UserCacheService {

    final UserCacheRepository userCacheRepository;


}

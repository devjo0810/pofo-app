package com.pofo.pofoapp.common.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

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

    public void add(UserCache userCache) {
        userCacheRepository.save(userCache);
    }

    public void delete(Long id) {
        UserCache userCache = userCacheRepository.findById(id.toString())
                .orElseThrow(() -> new NotFoundException("해당 값을 찾을 수 없습니다."));
        userCacheRepository.delete(userCache);
    }

    public UserCache find(Long id) {
        return userCacheRepository.findById(id.toString())
                .orElseThrow(() -> new NotFoundException("해당 값을 찾을 수 없습니다."));
    }
}

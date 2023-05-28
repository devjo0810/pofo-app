package com.pofo.pofoapp.common.redis;

import org.springframework.data.repository.CrudRepository;

/**
 * packageName    : com.pofo.pofoapp.common.redis
 * fileName       : RedisRepository
 * author         : joyousang
 * date           : 2023/05/28
 * description    :
 */
public interface UserCacheRepository extends CrudRepository<UserCache, String> {
}

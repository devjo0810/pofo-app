package com.pofo.pofoapp.common.redis;

import com.pofo.pofoapp.common.jwt.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.pofo.pofoapp.common.redis
 * fileName       : UserCacheServiceTest
 * author         : joyousang
 * date           : 2023/05/28
 * description    :
 */
@SpringBootTest
class UserCacheServiceTest {
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserCacheService userCacheService;
    final Long TEST_USER_ID = 1L;

    @Test
    public void Redis_저장_성공(){
        //given
        String token = jwtTokenProvider.generateToken(TEST_USER_ID);
        UserCache userCache = UserCache.builder()
                .userId(TEST_USER_ID)
                .token(token)
                .email("test@test.com")
                .name("user1")
                .build();

        //when
        userCacheService.add(userCache);

        //then
        UserCache findUserCache = userCacheService.find(TEST_USER_ID);
        assertEquals(token, findUserCache.getToken());

    }
}
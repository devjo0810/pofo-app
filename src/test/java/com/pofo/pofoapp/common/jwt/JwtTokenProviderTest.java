package com.pofo.pofoapp.common.jwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.pofo.pofoapp.common.jwt
 * fileName       : JwtTokenProviderTest
 * author         : joyousang
 * date           : 2023/05/28
 * description    :
 */
@SpringBootTest
class JwtTokenProviderTest {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Test
    public void JWT토큰발행_성공(){
        //given
        Long userId = 100L;

        //when
        String token = jwtTokenProvider.generateToken(userId);

        //then
        Long tokenUserId = jwtTokenProvider.getUserIdFromToken(token);
        assertEquals(userId, tokenUserId);

    }

}
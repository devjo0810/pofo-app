package com.pofo.pofoapp.user;

import com.pofo.pofoapp.domain.User;
import com.pofo.pofoapp.domain.type.UserStatusType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.pofo.pofoapp.user
 * fileName       : UserServiceTest
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void 회원가입_성공(){
        //given
        User user1 = User.builder()
                .email("abc@email.com")
                .name("user1")
                .status(UserStatusType.ACTIVE)
                .password("12345678")
                .build();

        //when
        Long joinId = userService.join(user1);

        //then
        assertEquals(joinId, user1.getId());

    }

    @Test
    public void 회원가입_실패_중복된유저명(){
        //given
        User user1 = User.builder()
                .email("abc@email.com")
                .name("user1")
                .status(UserStatusType.ACTIVE)
                .password("12345678")
                .build();
        User user2 = User.builder()
                .email("def@email.com")
                .name("user1")
                .status(UserStatusType.ACTIVE)
                .password("12345678")
                .build();

        //when
        userService.join(user1);

        //then
        assertThrows(IllegalStateException.class, () -> userService.join(user2));
    }

    @Test
    public void 회원가입_실패_중복된이메일(){
        //given
        User user1 = User.builder()
                .email("abc@email.com")
                .name("user1")
                .status(UserStatusType.ACTIVE)
                .password("12345678")
                .build();
        User user2 = User.builder()
                .email("abc@email.com")
                .name("user2")
                .status(UserStatusType.ACTIVE)
                .password("12345678")
                .build();

        //when
        userService.join(user1);

        //then
        assertThrows(IllegalStateException.class, () -> userService.join(user2));
    }
}
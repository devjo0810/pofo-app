package com.pofo.pofoapp.service;

import com.pofo.pofoapp.domain.User;
import com.pofo.pofoapp.domain.type.UserStatusType;
import com.pofo.pofoapp.exception.ValidateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.pofo.pofoapp.service
 * fileName       : UserServiceTest
 * author         : joyousang
 * date           : 2023/05/30
 * description    :
 */
@SpringBootTest
@Transactional
class UserServiceTest {
    
    @Autowired UserService userService;
    
    @Test
    public void 회원가입(){
        //given
        User user = createUser("홍길동", "test@test.com", UserStatusType.ACTIVE, "test1234");

        //when
        Long joinId = userService.join(user);

        //then
        assertEquals(joinId, user.getId());
    }

    @Test
    public void 회원가입_중복된사용자명(){
        //given
        User user1 = createUser("홍길동", "test123@test.com", UserStatusType.ACTIVE, "test1234");
        User user2 = createUser("홍길동", "test456@test.com", UserStatusType.ACTIVE, "test1234");

        //when
        Long joinId = userService.join(user1);

        //then
        assertThrows(ValidateException.class, () -> userService.join(user2));
    }

    @Test
    public void 회원가입_중복된이메일(){
        //given
        User user1 = createUser("홍길동", "test123@test.com", UserStatusType.ACTIVE, "test1234");
        User user2 = createUser("이순신", "test123@test.com", UserStatusType.ACTIVE, "test1234");

        //when
        Long joinId = userService.join(user1);

        //then
        assertThrows(ValidateException.class, () -> userService.join(user2));
    }

    private static User createUser(String name, String email, UserStatusType type, String password) {
        return User.builder()
                .name(name)
                .email(email)
                .status(type)
                .password(password)
                .build();
    }

}
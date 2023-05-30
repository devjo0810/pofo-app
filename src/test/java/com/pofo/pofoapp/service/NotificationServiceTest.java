package com.pofo.pofoapp.service;

import com.pofo.pofoapp.domain.Notification;
import com.pofo.pofoapp.domain.User;
import com.pofo.pofoapp.domain.type.UserStatusType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.pofo.pofoapp.service
 * fileName       : NotificationServiceTest
 * author         : joyousang
 * date           : 2023/05/30
 * description    :
 */
@SpringBootTest
@Transactional
class NotificationServiceTest {

    @Autowired NotificationService notificationService;
    @Autowired UserService userService;

    @Test
    public void 알림생성(){
        //given
        User user = createUser("홍길동", "test@test.com", UserStatusType.ACTIVE, "test1234");
        Long userId = userService.join(user);
        String notificationContent = "알림 테스트123";

        //when
        Long notificationId = notificationService.createNotification(userId, notificationContent);

        //then
        Notification notification = notificationService.findNotification(notificationId);
        assertEquals(notificationContent, notification.getContent());
    }

    @Test
    public void 알림생성_존재하지않는사용자(){
        //given
        Long userId = 999L;
        String notificationContent = "알림 테스트123";

        //when
        //then
        assertThrows(EntityNotFoundException.class,
                () -> notificationService.createNotification(userId, notificationContent));
    }

    @Test
    public void 알림삭제(){
        //given
        User user = createUser("홍길동", "test@test.com", UserStatusType.ACTIVE, "test1234");
        Long userId = userService.join(user);
        String notificationContent = "알림 테스트123";
        Long notificationId = notificationService.createNotification(userId, notificationContent);

        //when
        notificationService.deleteNotification(notificationId);

        //then
        assertThrows(EntityNotFoundException.class,
                () -> notificationService.findNotification(notificationId));
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
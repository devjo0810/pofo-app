package com.pofo.pofoapp.notification;

import com.pofo.pofoapp.domain.Notification;
import com.pofo.pofoapp.domain.User;
import com.pofo.pofoapp.domain.type.UserStatusType;
import com.pofo.pofoapp.user.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.pofo.pofoapp.notification
 * fileName       : NotificationServiceTest
 * author         : joyousang
 * date           : 2023/05/28
 * description    :
 */
@SpringBootTest
@Transactional
class NotificationServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    NotificationService notificationService;

    final String USER_NAME = "user1";

    @BeforeEach
    void joinUser() {
        User user1 = User.builder()
                .email("abc@email.com")
                .name(USER_NAME)
                .status(UserStatusType.ACTIVE)
                .password("12345678")
                .build();
        userService.join(user1);
    }

    @Test
    public void 알림등록_성공(){
        //given
        User findUser = userService.findAllByName(USER_NAME).stream().findFirst().orElse(null);
        Notification noti = Notification.builder()
                .content("알림 등록1")
                .user(findUser)
                .build();

        //when
        Long notiId = notificationService.add(noti);

        //then
        List<Notification> findNotiList = notificationService.findAllByUserId(findUser.getId());
        assertTrue(
            findNotiList.stream().anyMatch(findNoti -> findNoti.getId().equals(notiId))
        );
    }
}
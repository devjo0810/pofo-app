package com.pofo.pofoapp.user;

import com.pofo.pofoapp.domain.Follow;
import com.pofo.pofoapp.domain.User;
import com.pofo.pofoapp.domain.type.UserStatusType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.pofo.pofoapp.user
 * fileName       : FollowServiceTest
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
@SpringBootTest
@Transactional
class FollowServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    FollowService followService;
    @Test
    public void 팔로우_성공(){
        //given
        User user1 = User.builder()
                .email("abc@email.com")
                .name("user1")
                .status(UserStatusType.ACTIVE)
                .password("12345678")
                .build();
        User user2 = User.builder()
                .email("def@email.com")
                .name("user2")
                .status(UserStatusType.ACTIVE)
                .password("12345678")
                .build();
        Long joinId1 = userService.join(user1);
        Long joinId2 = userService.join(user2);

        //when
        Long followId = followService.follow(joinId1, joinId2); // 1 -> 2 를 팔로우
        List<Follow> follows = followService.findByFollowerId(joinId1); // 1이 팔로우하는 목록 조회
        Follow findFollow = follows.stream()
                .filter(follow -> follow.getFollowee().getId().equals(joinId2))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("팔로우 안됨"));

        //then
        assertEquals(findFollow.getFollowee().getId(), joinId2);

    }

}
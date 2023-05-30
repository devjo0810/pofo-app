package com.pofo.pofoapp.service;

import com.pofo.pofoapp.domain.Follow;
import com.pofo.pofoapp.domain.User;
import com.pofo.pofoapp.domain.type.UserStatusType;
import com.pofo.pofoapp.repository.FollowRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.pofo.pofoapp.service
 * fileName       : FollowServiceTest
 * author         : joyousang
 * date           : 2023/05/30
 * description    :
 */
@SpringBootTest
@Transactional
class FollowServiceTest {
    @Autowired FollowService followService;
    @Autowired
    FollowRepository followRepository;
    @Autowired UserService userService;

    @Test
    public void 팔로우(){
        //given
        User follower = createUser("홍길동", "test123@test.com", UserStatusType.ACTIVE, "test1234");
        User followTarget = createUser("이순신", "test456@test.com", UserStatusType.ACTIVE, "test1234");
        Long followerId = userService.join(follower);
        Long followTargetId = userService.join(followTarget);

        //when
        followService.follow(followerId, followTargetId);

        //then
        List<Follow> list = followRepository.findAllByFollowerIdAndFolloweeId(followerId, followTargetId);
        assertTrue(!list.isEmpty());
    }

    @Test
    public void 언팔로우(){
        //given
        User follower = createUser("홍길동", "test123@test.com", UserStatusType.ACTIVE, "test1234");
        User followTarget = createUser("이순신", "test456@test.com", UserStatusType.ACTIVE, "test1234");
        Long followerId = userService.join(follower);
        Long followTargetId = userService.join(followTarget);
        followService.follow(followerId, followTargetId);

        //when
        followService.unFollow(followerId, followTargetId);

        //then
        List<Follow> list = followRepository.findAllByFollowerIdAndFolloweeId(followerId, followTargetId);
        assertTrue(list.isEmpty());
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
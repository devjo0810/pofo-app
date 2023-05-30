package com.pofo.pofoapp.service;

import com.pofo.pofoapp.domain.Follow;
import com.pofo.pofoapp.domain.User;
import com.pofo.pofoapp.exception.ValidateException;
import com.pofo.pofoapp.repository.FollowRepository;
import com.pofo.pofoapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * packageName    : com.pofo.pofoapp.user
 * fileName       : FollowService
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FollowService {

    final FollowRepository followRepository;
    final UserService userService;

    /**
     * 팔로우
     * @param followerId
     * @param followeeId
     * @return follow id
     */
    @Transactional
    public Long follow(Long followerId, Long followeeId) {
        // 유저 본인
        User follower = userService.findUser(followerId);

        // 팔로우 대상
        User followTarget = userService.findUser(followeeId);

        // 팔로우중인지 체크
        List<Follow> findFollows = followRepository.findAllByFollowerIdAndFolloweeId(followerId, followeeId);
        if (!findFollows.isEmpty()) {
            throw new ValidateException("이미 팔로우중인 회원입니다");
        }

        Follow follow = followRepository.save(Follow.builder()
                .follower(follower)
                .followee(followTarget)
                .build());
        return follow.getId();
    }

    @Transactional
    public void unFollow(Long followerId, Long followeeId) {
        // 팔로우중인지 체크
        List<Follow> findFollows = followRepository.findAllByFollowerIdAndFolloweeId(followerId, followeeId);
        if (findFollows.isEmpty()) {
            throw new ValidateException("팔로우중인 회원이 아닙니다");
        }
        followRepository.delete(findFollows.get(0));
    }
}

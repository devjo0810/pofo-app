package com.pofo.pofoapp.user;

import com.pofo.pofoapp.domain.Follow;
import com.pofo.pofoapp.domain.User;
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
@Transactional
public class FollowService {

    final FollowRepository followRepository;
    final UserRepository userRepository;

    /**
     * 팔로우
     * @param followerId
     * @param followeeId
     * @return follow id
     */
    public Long follow(Long followerId, Long followeeId) {
        // 유저 본인
        User follower = userRepository.findById(followerId).orElseThrow(() -> new IllegalStateException("잘못된 유저에 대한 값입니다."));
        // 팔로우 대상
        User followee = userRepository.findById(followeeId).orElseThrow(() -> new IllegalStateException("존재하지 않는 유저입니다."));
        Follow follow = Follow.builder().follower(follower).followee(followee).build();
        followRepository.save(follow);
        return follow.getId();
    }

    public void unFollow(Long id) {
        Follow follow = followRepository.findById(id).orElseThrow(() -> new IllegalStateException("존재하지 않는 팔로우입니다."));
        followRepository.delete(follow);
    }

    @Transactional(readOnly = true)
    public List<Follow> findByFollowerId(Long followerId) {
        return followRepository.findByFollowerId(followerId);
    }
    @Transactional(readOnly = true)
    public List<Follow> findByFolloweeId(Long followeeId) {
        return followRepository.findByFollowerId(followeeId);
    }
}

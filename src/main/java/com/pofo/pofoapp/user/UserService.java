package com.pofo.pofoapp.user;

import com.pofo.pofoapp.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * packageName    : com.pofo.pofoapp.user
 * fileName       : UserService
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    final UserRepository userRepository;

    /**
     * 회원가입
     * @param user
     * @return userId
     */
    public Long join(User user) {
        validateDuplicateName(user.getName());
        validateDuplicateEmail(user.getEmail());
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateEmail(String email) {
        List<User> findUsers = userRepository.findAllByEmail(email);
        if (!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }
    }

    private void validateDuplicateName(String name) {
        List<User> findUsers = userRepository.findAllByName(name);
        if (!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 유저명입니다.");
        }
    }

    /**
     * 사용자 단건 조회
     * @param id
     * @return user
     */
    @Transactional(readOnly = true)
    public User find(Long id) {
        return userRepository.findById(id).orElse(null);
    }

//    /**
//     * 사용자 조회
//     * @param name
//     * @return users
//     */
//    public List<User> findAllByName(String name) {
//        return userRepository.findAllByName(name);
//    }
//
//    /**
//     * 사용자 조회
//     * @param email
//     * @return users
//     */
//    public List<User> findAllByEmail(String email) {
//        return userRepository.findAllByEmail(email);
//    }

}

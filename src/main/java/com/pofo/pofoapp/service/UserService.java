package com.pofo.pofoapp.service;

import com.pofo.pofoapp.domain.User;
import com.pofo.pofoapp.exception.ValidateException;
import com.pofo.pofoapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
@Transactional(readOnly = true)
public class UserService {
    final UserRepository userRepository;

    /**
     * 회원가입
     * @param user
     * @return userId
     */
    @Transactional
    public Long join(User user) {
        validateDuplicateName(user.getName());
        validateDuplicateEmail(user.getEmail());
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateEmail(String email) {
        List<User> findUsers = userRepository.findAllByEmail(email);
        if (!findUsers.isEmpty()) {
            throw new ValidateException("이미 존재하는 이메일입니다");
        }
    }

    private void validateDuplicateName(String name) {
        List<User> findUsers = userRepository.findAllByName(name);
        if (!findUsers.isEmpty()) {
            throw new ValidateException("이미 존재하는 유저명입니다");
        }
    }

    /**
     * 사용자 단건 조회
     * @param id
     * @return user
     */
    public User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("해당 회원을 찾을 수 없습니다"));
    }

}

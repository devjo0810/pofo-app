package com.pofo.pofoapp.repository;

import com.pofo.pofoapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * packageName    : com.pofo.pofoapp.user
 * fileName       : UserRepository
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByName(String name);
    List<User> findAllByEmail(String email);
}

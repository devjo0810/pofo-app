package com.pofo.pofoapp.notification;

import com.pofo.pofoapp.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * packageName    : com.pofo.pofoapp.notification
 * fileName       : NotificationRepository
 * author         : joyousang
 * date           : 2023/05/28
 * description    :
 */
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    @Query("select n from Notification n where n.user.id = :userId")
    List<Notification> findAllByUserId(@Param("userId") Long userId);
}

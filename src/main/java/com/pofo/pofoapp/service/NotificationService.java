package com.pofo.pofoapp.service;

import com.pofo.pofoapp.domain.Notification;
import com.pofo.pofoapp.domain.User;
import com.pofo.pofoapp.repository.NotificationRepository;
import com.pofo.pofoapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * packageName    : com.pofo.pofoapp.notification
 * fileName       : NotificationService
 * author         : joyousang
 * date           : 2023/05/28
 * description    :
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NotificationService {

    final NotificationRepository notificationRepository;
    final UserService userService;

    /**
     * 알림 등록
     * @param userId
     * @param content
     * @return notification id
     */
    @Transactional
    public Long createNotification(Long userId, String content) {
        User user = userService.findUser(userId);
        Notification notification = Notification.builder()
                .content(content)
                .user(user)
                .build();
        notificationRepository.save(notification);
        return notification.getId();
    }

    /**
     * 알림 삭제
     * @param notificationId
     */
    @Transactional
    public void deleteNotification(Long notificationId) {
        Notification notification = findNotification(notificationId);
        notificationRepository.delete(notification);
    }

    public Notification findNotification(Long notificationId) {
        return notificationRepository.findById(notificationId)
                .orElseThrow(() -> new EntityNotFoundException("해당 알림을 찾을 수 없습니다"));
    }

    public List<Notification> findAllByUserId(Long userId) {
        return notificationRepository.findAllByUserId(userId);
    }
}

package com.pofo.pofoapp.notification;

import com.pofo.pofoapp.domain.Notification;
import com.pofo.pofoapp.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class NotificationService {

    final NotificationRepository notificationRepository;

    public Long add(Notification notification) {
        validateNullUser(notification.getUser());
        notificationRepository.save(notification);
        return notification.getId();
    }

    private void validateNullUser(User user) {
        if (user == null) {
            throw new IllegalStateException("알림등록할 유저가 없습니다.");
        }
    }

    public void delete(Long id) {
        notificationRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 알림입니다."));
        notificationRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Notification> findAllByUserId(Long userId) {
        return notificationRepository.findAllByUserId(userId);
    }
}

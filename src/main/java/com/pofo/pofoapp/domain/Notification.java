package com.pofo.pofoapp.domain;

import com.pofo.pofoapp.domain.common.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * packageName    : com.pofo.pofoapp.domain
 * fileName       : Notification
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
@Entity
@Getter
@NoArgsConstructor
public class Notification extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "notification_id")
    private Long id;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Notification(String content, User user) {
        this.content = content;
        this.user = user;
    }
}

package com.pofo.pofoapp.domain;

import com.pofo.pofoapp.domain.common.BaseEntity;
import com.pofo.pofoapp.domain.type.UserStatusType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * packageName    : com.pofo.pofoapp.domain
 * fileName       : User
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    @Column(name = "username")
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserStatusType status;
    private LocalDateTime rcntLgnAt; // 최근로그인일시
    private int pwdFailCnt; // 비밀번호실패횟수

    @Builder
    public User(String name, String email, String password, UserStatusType status) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
    }
}

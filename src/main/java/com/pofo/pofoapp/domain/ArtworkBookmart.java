package com.pofo.pofoapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * packageName    : com.pofo.pofoapp.domain
 * fileName       : ArtworkBookmart
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
@Entity
@Getter
@NoArgsConstructor
public class ArtworkBookmart {
    @Id @GeneratedValue
    @Column(name = "bookmark_id")
    private Long id;
    @CreatedDate
    private LocalDateTime bookmarkedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artwork_id")
    private Artwork artwork;
}

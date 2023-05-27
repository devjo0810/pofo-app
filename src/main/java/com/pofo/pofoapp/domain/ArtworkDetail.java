package com.pofo.pofoapp.domain;

import com.pofo.pofoapp.domain.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * packageName    : com.pofo.pofoapp.domain
 * fileName       : ArtworkDetail
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
@Entity
@Getter
@NoArgsConstructor
public class ArtworkDetail extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "artwork_detail_id")
    private Long id;
    private int sortSqnc;
    private String filePath;
    private String originFileName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artwork_id")
    private Artwork artwork;
}

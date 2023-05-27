package com.pofo.pofoapp.domain;

import com.pofo.pofoapp.domain.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * packageName    : com.pofo.pofoapp.domain
 * fileName       : Artwork
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
@Entity
@Getter
@NoArgsConstructor
public class Artwork extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "artwork_id")
    private Long id;
    private String title;
    private String description;
    private String category;
    private Long viewCnt;
    private String viewYn;

}

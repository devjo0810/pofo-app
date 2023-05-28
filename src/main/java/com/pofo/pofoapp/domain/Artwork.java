package com.pofo.pofoapp.domain;

import com.pofo.pofoapp.domain.common.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "artwork", cascade = CascadeType.ALL)
    private List<ArtworkDetail> artworkDetails = new ArrayList<>();

    @Builder
    public Artwork(String title, String description, String category, String viewYn) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.viewYn = viewYn;
    }
    public void addDetail(ArtworkDetail artworkDetail) {
        artworkDetails.add(artworkDetail);
        artworkDetail.setArtwork(this);
    }
}

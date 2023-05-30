package com.pofo.pofoapp.repository;

import com.pofo.pofoapp.domain.ArtworkDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * packageName    : com.pofo.pofoapp.artwork
 * fileName       : ArtworkDetailRepository
 * author         : joyousang
 * date           : 2023/05/28
 * description    :
 */
public interface ArtworkDetailRepository extends JpaRepository<ArtworkDetail, Long> {

    @Query("select ad from ArtworkDetail ad where ad.artwork.id = :artworkId")
    List<ArtworkDetail> findAllByArtworkId(@Param("artworkId") Long artworkId);
}

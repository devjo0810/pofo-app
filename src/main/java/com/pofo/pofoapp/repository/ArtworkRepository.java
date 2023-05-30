package com.pofo.pofoapp.repository;

import com.pofo.pofoapp.domain.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * packageName    : com.pofo.pofoapp.artwork
 * fileName       : ArtworkRepository
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
public interface ArtworkRepository extends JpaRepository<Artwork, Long> {

    @Query("select a from Artwork a join fetch a.artworkDetails ad where a.id = :id")
    Artwork findOne(@Param("id") Long id);
}

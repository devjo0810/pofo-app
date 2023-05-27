package com.pofo.pofoapp.artwork;

import com.pofo.pofoapp.domain.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.pofo.pofoapp.artwork
 * fileName       : ArtworkRepository
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
}

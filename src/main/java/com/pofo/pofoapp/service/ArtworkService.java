package com.pofo.pofoapp.service;

import com.pofo.pofoapp.domain.Artwork;
import com.pofo.pofoapp.repository.ArtworkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName    : com.pofo.pofoapp.artwork
 * fileName       : ArtworkService
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArtworkService {

    final ArtworkRepository artworkRepository;

    @Transactional
    public Long createArtwork(Artwork artwork) {
        artworkRepository.save(artwork);
        return artwork.getId();
    }

}

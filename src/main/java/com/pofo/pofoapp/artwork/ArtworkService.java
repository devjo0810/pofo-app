package com.pofo.pofoapp.artwork;

import com.pofo.pofoapp.domain.Artwork;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * packageName    : com.pofo.pofoapp.artwork
 * fileName       : ArtworkService
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ArtworkService {

    final ArtworkRepository artworkRepository;

    public Long save(Artwork artwork) {
        artworkRepository.save(artwork);
        return artwork.getId();
    }

    public Artwork findOne(Long id) {
        return artworkRepository.findOne(id);
    }

}

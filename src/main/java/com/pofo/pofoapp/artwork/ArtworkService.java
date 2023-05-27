package com.pofo.pofoapp.artwork;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.pofo.pofoapp.artwork
 * fileName       : ArtworkService
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
@Service
@RequiredArgsConstructor
public class ArtworkService {

    final ArtworkRepository artworkRepository;
}

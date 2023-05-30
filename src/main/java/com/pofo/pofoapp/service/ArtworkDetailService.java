package com.pofo.pofoapp.service;

import com.pofo.pofoapp.domain.ArtworkDetail;
import com.pofo.pofoapp.repository.ArtworkDetailRepository;
import com.pofo.pofoapp.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.pofo.pofoapp.artwork
 * fileName       : ArtworkDetailService
 * author         : joyousang
 * date           : 2023/05/28
 * description    :
 */
@Service
@RequiredArgsConstructor
public class ArtworkDetailService {

    final ArtworkDetailRepository artworkDetailRepository;

    public List<ArtworkDetail> changeDetails(List<MultipartFile> files) {
        List<ArtworkDetail> artworkDetails = new ArrayList<>();
        for (int i = 0; i < files.size(); i++) {
            artworkDetails.add(changeDetail(files.get(i), i + 1));
        }
        return artworkDetails;
    }

    private ArtworkDetail changeDetail(MultipartFile file, int sortSqnc) {
        String uploadFullPath = FileUtil.uploadFile(file);
        return ArtworkDetail.builder()
                .filePath(uploadFullPath)
                .originFileName(file.getOriginalFilename())
                .sortSqnc(sortSqnc)
                .build();
    }

    public List<ArtworkDetail> findAllByArtworkId(Long artworkId) {
        return artworkDetailRepository.findAllByArtworkId(artworkId);
    }
}

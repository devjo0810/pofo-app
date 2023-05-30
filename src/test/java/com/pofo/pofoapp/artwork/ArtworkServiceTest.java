package com.pofo.pofoapp.artwork;

import com.pofo.pofoapp.domain.Artwork;
import com.pofo.pofoapp.domain.ArtworkDetail;
import com.pofo.pofoapp.service.ArtworkDetailService;
import com.pofo.pofoapp.service.ArtworkService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.pofo.pofoapp.artwork
 * fileName       : ArtworkServiceTest
 * author         : joyousang
 * date           : 2023/05/28
 * description    :
 */
@SpringBootTest

class ArtworkServiceTest {

    @Autowired
    ArtworkService artworkService;
    @Autowired
    ArtworkDetailService artworkDetailService;
    List<ArtworkDetail> artworkDetails;

    @BeforeEach
    public void before() {
        MultipartFile file1 =
                new MockMultipartFile("file", "test1.txt", "text/plain", "Test file content 123".getBytes());
        MultipartFile file2 =
                new MockMultipartFile("file", "test2.txt", "text/plain", "Test file content 456".getBytes());
        MultipartFile file3 =
                new MockMultipartFile("file", "test3.txt", "text/plain", "Test file content 789".getBytes());
        List<MultipartFile> files = new ArrayList<>(List.of(file1, file2, file3));
        artworkDetails = artworkDetailService.changeDetails(files);
    }

    @AfterEach
    public void after() throws Exception {
        for (ArtworkDetail artworkDetail : artworkDetails) {
            Files.deleteIfExists(Path.of(artworkDetail.getFilePath()));
        }
    }

    @Test
    public void Artwork_저장_성공(){
        //given
        Artwork artwork = Artwork.builder()
                .title("artwork1")
                .viewYn("Y")
                .category("test")
                .description("description1")
                .build();
        for (ArtworkDetail artworkDetail : artworkDetails) {
            artwork.addDetail(artworkDetail);
        }

        //when
        Long saveId = artworkService.createArtwork(artwork);

        //then
        List<ArtworkDetail> details = artworkDetailService.findAllByArtworkId(saveId);
        assertFalse(details.isEmpty());

    }

}
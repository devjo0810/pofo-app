package com.pofo.pofoapp.artwork;

import com.pofo.pofoapp.domain.ArtworkDetail;
import com.pofo.pofoapp.service.ArtworkDetailService;
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
 * fileName       : ArtworkDetailServiceTest
 * author         : joyousang
 * date           : 2023/05/28
 * description    :
 */
@SpringBootTest
class ArtworkDetailServiceTest {

    @Autowired
    ArtworkDetailService artworkDetailService;

    @Test
    public void 파일목록_추가_성공() throws Exception {
        //given
        MultipartFile file1 =
                new MockMultipartFile("file", "test1.txt", "text/plain", "Test file content 123".getBytes());
        MultipartFile file2 =
                new MockMultipartFile("file", "test2.txt", "text/plain", "Test file content 456".getBytes());
        MultipartFile file3 =
                new MockMultipartFile("file", "test3.txt", "text/plain", "Test file content 789".getBytes());
        List<MultipartFile> files = new ArrayList<>(List.of(file1, file2, file3));

        //when
        List<ArtworkDetail> artworkDetails = artworkDetailService.changeDetails(files);

        //then
        assertEquals(file1.getOriginalFilename(), artworkDetails.get(0).getOriginFileName());
        assertEquals(file2.getOriginalFilename(), artworkDetails.get(1).getOriginFileName());
        assertEquals(file3.getOriginalFilename(), artworkDetails.get(2).getOriginFileName());

        //end
        for (ArtworkDetail artworkDetail : artworkDetails) {
            Files.deleteIfExists(Path.of(artworkDetail.getFilePath()));
        }
    }
}
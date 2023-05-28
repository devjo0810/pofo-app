package com.pofo.pofoapp.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.pofo.pofoapp.util
 * fileName       : FileUtilTest
 * author         : joyousang
 * date           : 2023/05/28
 * description    :
 */
@SpringBootTest
class FileUtilTest {

    @Test
    public void 파일업로드_성공() throws Exception {
        //given
        String originalFilename = "test.txt";
        String content = "Test file content";
        byte[] contentBytes = content.getBytes();
        MultipartFile file =
                new MockMultipartFile("file", originalFilename, "text/plain", contentBytes);

        //when
        String fullFilePath = FileUtil.uploadFile(file);
        String uploadContent = Files.readString(Path.of(fullFilePath));

        //then
        assertEquals(content, uploadContent);

        //end
        Files.deleteIfExists(Path.of(fullFilePath));
    }
}
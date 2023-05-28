package com.pofo.pofoapp.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * packageName    : com.pofo.pofoapp.util
 * fileName       : FileUtil
 * author         : joyousang
 * date           : 2023/05/28
 * description    :
 */
@Component
@Slf4j
public class FileUtil {
    private static String UPLOAD_PATH;

    @Autowired
    private FileUtil(Environment environment) {
        String currentDirectory = System.getProperty("user.dir");
        log.info("currentDirectory: {}", currentDirectory);
        String uploadPath = environment.getProperty("app.file.upload.path");
        log.info("uploadPath: {}", uploadPath);
        UPLOAD_PATH = currentDirectory + uploadPath;
    }

    @PostConstruct
    private void init() {
        createUploadDirectory();
    }

    private void createUploadDirectory() {
        File uploadDir = new File(UPLOAD_PATH);
        System.out.println(uploadDir);
        if (!uploadDir.exists()) {
            if (!uploadDir.mkdirs()) {
                throw new RuntimeException("Failed to create upload directory: " + UPLOAD_PATH);
            }
        }
    }

    public static String uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("업로드할 파일이 없습니다.");
        }

        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        String fileName = generateUniqueFileName(originalFilename);

        String filePath = UPLOAD_PATH + File.separator + fileName;
        File dest = new File(filePath);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException("파일 업로드 에러");
        }

        return filePath;
    }

    private static String generateUniqueFileName(String originalFilename) {
        String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
//        String baseName = originalFilename.substring(0, originalFilename.lastIndexOf("."));
        String uniqueFileName = UUID.randomUUID().toString() + "." + extension;

        return uniqueFileName;
    }
}

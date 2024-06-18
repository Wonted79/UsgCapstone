package usg.capstone.server.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import usg.capstone.server.domain.ImageData;
import usg.capstone.server.repository.StorageRepository;
import usg.capstone.server.util.ImageUtils;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class StorageService {

    private final StorageRepository storageRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        log.info("upload file: {}", file);
        ImageData imageData = storageRepository.save(
                ImageData.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes()))
                        .build());
        if (imageData != null) {
            log.info("imageData: {}", imageData);
            return "file uploaded successfully : " + file.getOriginalFilename();
        }

        return null;
    }

    // 이미지 파일로 압축하기
    public byte[] downloadImage(String fileName) {
        ImageData imageData = storageRepository.findByName(fileName)
                .orElseThrow(RuntimeException::new);

        log.info("download imageData: {}", imageData);

        return ImageUtils.decompressImage(imageData.getImageData());
    }
}
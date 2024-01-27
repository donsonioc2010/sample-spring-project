package com.example.jong1.core.api.domain.common;

import com.example.jong1.core.api.domain.common.data.UploadData;
import com.example.jong1.core.enums.common.DataStatus;
import com.example.jong1.storage.db.core.common.entity.AttachEntity;
import com.example.jong1.storage.db.core.common.repository.AttachRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttachUploadService {
    private final AttachRepository attachRepository;

    public void uploadFile(UploadData uploadData) {
        String path = Paths.get("").toAbsolutePath().toString() + "/" + uploadData.getUsage();
        String newFileName = UUID.randomUUID().toString();
        log.info("uploadFile path >>> {} ", path);

        attachRepository.save(
                AttachEntity.builder()
                        .status(DataStatus.USE)
                        .originalFileName(
                                Normalizer.normalize(
                                        uploadData.getAttach().getOriginalFilename(), Normalizer.Form.NFC
                                )
                        )
                        .savedFileName(newFileName)
                        .path(path)
                        .extension(".jpg")
                        .build()
        );
    }


}

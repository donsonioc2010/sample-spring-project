package com.example.jong1.core.api.controller.common;

import com.example.jong1.core.api.controller.common.request.AttachUploadRequestV1;
import com.example.jong1.core.api.domain.common.AttachUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/attach")
@RequiredArgsConstructor
public class AttachControllerV1 {
    private final AttachUploadService attachUploadService;

    @PostMapping(value = "/upload", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFile(@Validated AttachUploadRequestV1 request) {
        attachUploadService.uploadFile(request.toUploadData());
        return ResponseEntity.ok("upload");
    }
}

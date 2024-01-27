package com.example.jong1.core.api.controller.common.request;

import com.example.jong1.core.api.domain.common.data.UploadData;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttachUploadRequestV1 {

    @NotBlank(message = "{attach.null.usage}")
    private String usage;

    @NotNull(message = "{attach.null.multipart}")
    private MultipartFile attach;

    public UploadData toUploadData() {
        return UploadData.builder()
                .requestVersion("V1")
                .usage(usage)
                .attach(attach)
                .build();
    }
}

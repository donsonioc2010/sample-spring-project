package com.example.jong1.core.api.controller.common;

import com.example.jong1.core.api.domain.common.CrawlingKYService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/craw")
public class SongCrawlingController {

    private final CrawlingKYService crawlingKYService;

    @GetMapping("/namu/ky")
    private void crawlingKyNamuWiki() {
        crawlingKYService.processKyCrawAndUpload();
    }
}

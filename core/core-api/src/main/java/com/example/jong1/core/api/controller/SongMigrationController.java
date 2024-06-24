package com.example.jong1.core.api.controller;

import com.example.jong1.core.api.domain.common.SongMigrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/song/migration")
public class SongMigrationController {
    private final SongMigrationService songMigrationService;

    @GetMapping
    public ResponseEntity<Void> songMigrate() {
        songMigrationService.migrate();
        return ResponseEntity.ok().build();
    }
}

package com.example.jong1.core.api.domain.common;

import com.example.jong1.storage.db.core.song.entity.SongNamuEntity;
import com.example.jong1.storage.db.core.song.repository.SongNamuRepository;
import com.example.jong1.storage.db.core.song.repository.SongRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SongMigrationService {

    private final SongRepository songRepository;
    private final SongNamuRepository songNamuRepository;

    @Transactional
    public void migrate() {
        final List<SongNamuEntity> namuEntityList = songNamuRepository.findAll();

        songRepository.saveAll(
            songRepository.findAll()
                .stream()
                .peek(song -> namuEntityList.stream()
                    .filter(songNamu -> songNamu.getTitle().equalsIgnoreCase(song.getTitle()) && songNamu.getArtist().equalsIgnoreCase(song.getArtist()))
                    .forEach(songNamu -> song.addSongCode(songNamu.getMachineType(), songNamu.getSongCode()))
                )
                .toList()
        );

    }
}

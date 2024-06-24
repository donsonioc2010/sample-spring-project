package com.example.jong1.storage.db.core.song.repository;

import com.example.jong1.storage.db.core.song.entity.SongNamuEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongNamuRepository extends JpaRepository<SongNamuEntity, Long> {
    List<SongNamuEntity> findByTitleAndArtist(String title, String artist);
}

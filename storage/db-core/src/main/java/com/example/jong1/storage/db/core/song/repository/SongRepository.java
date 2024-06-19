package com.example.jong1.storage.db.core.song.repository;

import com.example.jong1.storage.db.core.song.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<SongEntity, Long> {

}

package com.example.jong1.storage.db.core.song.entity;

import com.example.jong1.storage.db.core.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_SONG")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SongEntity extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String artist;

    @Column(nullable = false)
    private String songCode;

    @Enumerated(EnumType.STRING)
    private MachineType machineType;

    @Column(nullable = false)
    private String releaseMonth;

    @Builder
    private SongEntity(String title, String artist, String songCode, MachineType machineType,
        String releaseMonth) {
        this.title = title;
        this.artist = artist;
        this.songCode = songCode;
        this.machineType = machineType;
        this.releaseMonth = releaseMonth;
    }

    enum MachineType {
        TJ, KY
    }

    public static SongEntity ofMachineTypeKY(String title, String artist, String songCode, String releaseMonth) {
        return SongEntity.builder()
            .title(title)
            .artist(artist)
            .songCode(songCode)
            .releaseMonth(releaseMonth)
            .machineType(MachineType.KY)
            .build();
    }
}

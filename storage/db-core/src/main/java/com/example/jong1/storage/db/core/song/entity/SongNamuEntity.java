package com.example.jong1.storage.db.core.song.entity;

import com.example.jong1.storage.db.core.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_SONG_NAMU")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SongNamuEntity extends BaseEntity {

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
    private SongNamuEntity(String title, String artist, String songCode, MachineType machineType,
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

    private static SongNamuEntity of(String title, String artist, String songCode, String releaseMonth, MachineType machineType) {
        return SongNamuEntity.builder()
            .title(title)
            .artist(artist)
            .songCode(songCode)
            .releaseMonth(releaseMonth)
            .machineType(machineType)
            .build();
    }

    public static SongNamuEntity ofMachineTypeKY(String title, String artist, String songCode, String releaseMonth) {
        return of(title, artist, songCode, releaseMonth, MachineType.KY);
    }

    public static SongNamuEntity ofMachineTypeTJ(String title, String artist, String songCode, String releaseMonth) {
        return of(title, artist, songCode, releaseMonth, MachineType.TJ);
    }
}

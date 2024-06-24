package com.example.jong1.storage.db.core.song.entity;


import com.example.jong1.storage.db.core.BaseEntity;
import com.example.jong1.storage.db.core.song.entity.SongNamuEntity.MachineType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "TBL_SONG_CODE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SongCode extends BaseEntity {

    @Setter
    @Comment("곡정보 ID")
    @JoinColumn(name = "SONG_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Song song;

    @Comment("노래방 기기 종류 : TJ(TJ), KY(금영)")
    @Column(name = "MACHINE_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private MachineType machineType;

    @Comment("노래 곡 번호")
    @Setter
    @Column(name = "SONG_NUM", nullable = false)
    private String songNum;

    @Builder
    private SongCode(Song song, MachineType machineType, String songNum) {
        this.song = song;
        this.machineType = machineType;
        this.songNum = songNum;
    }

    public static SongCode of(MachineType machineType, String songNum) {
        return SongCode.builder()
            .machineType(machineType)
            .songNum(songNum)
            .build();
    }

}

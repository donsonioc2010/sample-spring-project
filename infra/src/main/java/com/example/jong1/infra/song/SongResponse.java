package com.example.jong1.infra.song;

import lombok.ToString;

public record SongResponse(
    String title,
    String artist,
    String number,
    String release
) {

}

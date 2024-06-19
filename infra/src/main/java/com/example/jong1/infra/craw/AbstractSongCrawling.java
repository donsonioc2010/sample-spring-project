package com.example.jong1.infra.craw;

import com.example.jong1.infra.song.SongResponse;
import java.util.List;

public abstract class AbstractSongCrawling {
    abstract List<SongResponse> process(String url);
}

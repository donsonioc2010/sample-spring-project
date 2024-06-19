package com.example.jong1.core.api.domain.common;


import com.example.jong1.infra.craw.NamuWikiCraw;
import com.example.jong1.infra.song.SongResponse;
import com.example.jong1.storage.db.core.song.entity.SongEntity;
import com.example.jong1.storage.db.core.song.repository.SongRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CrawlingKYService {
    private final SongRepository songRepository;
    private final NamuWikiCraw namuWikiCraw;


    // URL 입력받게 할 수 있는데, 그냥 직접 올려주는걸 택함. 많이 요청하면 밴때리니까...
    private String url =
        "https://namu.wiki/w/%EA%B8%88%EC%98%81%EC%97%94%ED%84%B0%ED%85%8C%EC%9D%B8%EB%A8%BC%ED%8A%B8/%EB%85%B8%EB%9E%98%EB%B0%A9%20%EC%88%98%EB%A1%9D%20%EB%AA%A9%EB%A1%9D/8001~9000";

    /**
     https://namu.wiki/w/%EA%B8%88%EC%98%81%EC%97%94%ED%84%B0%ED%85%8C%EC%9D%B8%EB%A8%BC%ED%8A%B8/%EB%85%B8%EB%9E%98%EB%B0%A9%20%EC%88%98%EB%A1%9D%20%EB%AA%A9%EB%A1%9D/101~1000
     https://namu.wiki/w/%EA%B8%88%EC%98%81%EC%97%94%ED%84%B0%ED%85%8C%EC%9D%B8%EB%A8%BC%ED%8A%B8/%EB%85%B8%EB%9E%98%EB%B0%A9%20%EC%88%98%EB%A1%9D%20%EB%AA%A9%EB%A1%9D/1001~2000
     https://namu.wiki/w/%EA%B8%88%EC%98%81%EC%97%94%ED%84%B0%ED%85%8C%EC%9D%B8%EB%A8%BC%ED%8A%B8/%EB%85%B8%EB%9E%98%EB%B0%A9%20%EC%88%98%EB%A1%9D%20%EB%AA%A9%EB%A1%9D/2001~3000
     https://namu.wiki/w/%EA%B8%88%EC%98%81%EC%97%94%ED%84%B0%ED%85%8C%EC%9D%B8%EB%A8%BC%ED%8A%B8/%EB%85%B8%EB%9E%98%EB%B0%A9%20%EC%88%98%EB%A1%9D%20%EB%AA%A9%EB%A1%9D/3001~4000
     https://namu.wiki/w/%EA%B8%88%EC%98%81%EC%97%94%ED%84%B0%ED%85%8C%EC%9D%B8%EB%A8%BC%ED%8A%B8/%EB%85%B8%EB%9E%98%EB%B0%A9%20%EC%88%98%EB%A1%9D%20%EB%AA%A9%EB%A1%9D/4001~5000
     https://namu.wiki/w/%EA%B8%88%EC%98%81%EC%97%94%ED%84%B0%ED%85%8C%EC%9D%B8%EB%A8%BC%ED%8A%B8/%EB%85%B8%EB%9E%98%EB%B0%A9%20%EC%88%98%EB%A1%9D%20%EB%AA%A9%EB%A1%9D/5001~6000
     https://namu.wiki/w/%EA%B8%88%EC%98%81%EC%97%94%ED%84%B0%ED%85%8C%EC%9D%B8%EB%A8%BC%ED%8A%B8/%EB%85%B8%EB%9E%98%EB%B0%A9%20%EC%88%98%EB%A1%9D%20%EB%AA%A9%EB%A1%9D/6001~7000
     https://namu.wiki/w/%EA%B8%88%EC%98%81%EC%97%94%ED%84%B0%ED%85%8C%EC%9D%B8%EB%A8%BC%ED%8A%B8/%EB%85%B8%EB%9E%98%EB%B0%A9%20%EC%88%98%EB%A1%9D%20%EB%AA%A9%EB%A1%9D/7001~8000
     https://namu.wiki/w/%EA%B8%88%EC%98%81%EC%97%94%ED%84%B0%ED%85%8C%EC%9D%B8%EB%A8%BC%ED%8A%B8/%EB%85%B8%EB%9E%98%EB%B0%A9%20%EC%88%98%EB%A1%9D%20%EB%AA%A9%EB%A1%9D/8001~9000
     */


    @Transactional
    public void processKyCrawAndUpload() {
        uploadKySong(crawlingKySong());
    }

    private List<SongResponse> crawlingKySong() {
        return namuWikiCraw.process(url);
    }

    private void uploadKySong(List<SongResponse> songDataList) {
        songRepository.saveAll(
            songDataList
                .stream()
                .map(song -> SongEntity.ofMachineTypeKY(
                    song.title(),
                    song.artist(),
                    song.number(),
                    song.release())
                ).toList()
        );
    }
}

package com.example.jong1.core.api.domain.common;

import com.example.jong1.infra.craw.NamuWikiTJCraw;
import com.example.jong1.infra.song.SongResponse;
import com.example.jong1.storage.db.core.song.entity.SongNamuEntity;
import com.example.jong1.storage.db.core.song.repository.SongNamuRepository;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CrawlingTJService {

    private final SongNamuRepository songNamuRepository;
    private final NamuWikiTJCraw namuWikiTJCraw;

    private String urlFormat =
        "https://namu.wiki/w/TJ미디어/노래방 수록 목록/%d~%d";
    private StartEndNum test = new StartEndNum(1, 1000);
    private List<StartEndNum> startEndNumList1 = List.of(
        new StartEndNum(1, 1000),
        new StartEndNum(1001, 2000),
        new StartEndNum(2001, 3000),
        new StartEndNum(3001, 4000),
        new StartEndNum(4001, 5000),
        new StartEndNum(5001, 6000),
        new StartEndNum(6001, 7000),
        new StartEndNum(7001, 8000),
        new StartEndNum(8001, 9000),
        new StartEndNum(9001, 10000)
    );
    private List<StartEndNum> startEndNumList2 = List.of(
        new StartEndNum(10001, 11000),
        new StartEndNum(11001, 12000),
        new StartEndNum(12001, 13000),
        new StartEndNum(13001, 14000),
        new StartEndNum(14001, 15000),
        new StartEndNum(15001, 16000),
        new StartEndNum(16001, 17000),
        new StartEndNum(17001, 18000),
        new StartEndNum(18001, 19000),
        new StartEndNum(19001, 20000)
    );
    private List<StartEndNum> startEndNumList3 = List.of(
        new StartEndNum(20001, 21000),
        new StartEndNum(21001, 22000),
        new StartEndNum(22001, 23000),
        new StartEndNum(23001, 24000),
        new StartEndNum(24001, 25000),
        new StartEndNum(25001, 26000),
        new StartEndNum(26001, 27000),
        new StartEndNum(27001, 28000),
        new StartEndNum(28001, 29000),
        new StartEndNum(29001, 30000)
    );
    private List<StartEndNum> startEndNumList4 = List.of(
        new StartEndNum(30001, 31000),
        new StartEndNum(31001, 32000),
        new StartEndNum(32001, 33000),
        new StartEndNum(33001, 34000),
        new StartEndNum(34001, 35000),
        new StartEndNum(35001, 36000),
        new StartEndNum(36001, 37000),
        new StartEndNum(37001, 38000),
        new StartEndNum(38001, 39000),
        new StartEndNum(39001, 40000)
    );
    private List<StartEndNum> startEndNumList5 = List.of(
        new StartEndNum(40001, 41000),
        new StartEndNum(41001, 42000),
        new StartEndNum(42001, 43000),
        new StartEndNum(43001, 44000),
        new StartEndNum(44001, 45000),
        new StartEndNum(45001, 46000),
        new StartEndNum(46001, 47000),
        new StartEndNum(47001, 48000),
        new StartEndNum(48001, 49000),
        new StartEndNum(49001, 50000)
    );
    private List<StartEndNum> startEndNumList6 = List.of(
        new StartEndNum(50001, 51000),
        new StartEndNum(51001, 52000),
        new StartEndNum(52001, 53000),
        new StartEndNum(53001, 54000),
        new StartEndNum(54001, 55000),
        new StartEndNum(55001, 56000),
        new StartEndNum(56001, 57000),
        new StartEndNum(57001, 58000),
        new StartEndNum(58001, 59000),
        new StartEndNum(59001, 60000)
    );
    private List<StartEndNum> startEndNumList7 = List.of(
        new StartEndNum(60001, 61000),
        new StartEndNum(61001, 62000),
        new StartEndNum(62001, 63000),
        new StartEndNum(63001, 64000),
        new StartEndNum(64001, 65000),
        new StartEndNum(65001, 66000),
        new StartEndNum(66001, 67000),
        new StartEndNum(67001, 68000),
        new StartEndNum(68001, 69000),
        new StartEndNum(69001, 70000)
    );
    private List<StartEndNum> startEndNumList8 = List.of(
        new StartEndNum(70001, 71000),
        new StartEndNum(71001, 72000),
        new StartEndNum(72001, 73000),
        new StartEndNum(73001, 74000),
        new StartEndNum(74001, 75000),
        new StartEndNum(75001, 76000),
        new StartEndNum(76001, 77000),
        new StartEndNum(77001, 78000),
        new StartEndNum(78001, 79000),
        new StartEndNum(79001, 80000)
    );
    private List<StartEndNum> startEndNumList9 = List.of(
        new StartEndNum(80001, 81000),
        new StartEndNum(81001, 82000),
        new StartEndNum(82001, 83000),
        new StartEndNum(83001, 84000),
        new StartEndNum(84001, 85000),
        new StartEndNum(85001, 86000),
        new StartEndNum(86001, 87000),
        new StartEndNum(87001, 88000),
        new StartEndNum(88001, 89000),
        new StartEndNum(89001, 90000)
    );
    private List<StartEndNum> startEndNumList10 = List.of(
        new StartEndNum(90001, 91000),
        new StartEndNum(91001, 92000),
        new StartEndNum(92001, 93000),
        new StartEndNum(93001, 94000),
        new StartEndNum(94001, 95000),
        new StartEndNum(95001, 96000),
        new StartEndNum(96001, 97000),
        new StartEndNum(97001, 98000),
        new StartEndNum(98001, 99000),
        new StartEndNum(99001, 99999)
    );


    @Transactional
    public void processTjCrawAndUpload() {
        List<SongResponse> songDataList = crawlingTJSong();
        log.warn("CrawlingTJSong >>> songDataListTotalSize : {}", songDataList.size());
        uploadSong(songDataList);
    }

    private List<SongResponse> crawlingTJSong() {
        return startEndNumList10.stream()
            .map(num -> {
                String url = String.format(urlFormat, num.getStart(), num.getEnd());
                List<SongResponse> result = namuWikiTJCraw.process(url);
                log.warn("CrawlingTJSong >>> URL : {}, start : {}, end : {}, resultSize : {}"
                    , url, num.getStart(), num.getEnd(), result.size());
                return result;
            })
            .flatMap(List::stream)
            .toList();
    }

    private void uploadSong(List<SongResponse> songDataList) {
        songNamuRepository.saveAll(
            songDataList
                .stream()
                .map(song -> SongNamuEntity.ofMachineTypeTJ(
                    song.title(),
                    song.artist(),
                    song.number(),
                    song.release())
                ).toList()
        );
    }

    @Getter
    private class StartEndNum {

        private final int start;
        private final int end;

        public StartEndNum(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

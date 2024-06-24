package com.example.jong1.infra.craw;


import com.example.jong1.infra.song.SongResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


@Slf4j
@Component
@RequiredArgsConstructor
public class NamuWikiTJCraw extends AbstractSongCrawling {

    @Override
    protected List<SongResponse> getDataList(WebDriver webDriver, String url) throws InterruptedException {
        webDriver.get(url);
        Thread.sleep(3000);
        List<WebElement> songListTables = webDriver.findElements(By.tagName("table"))
            .stream()
            .filter(table -> table.getAttribute("class").contains("_3vOfCO16"))
            .toList();

        if (songListTables.isEmpty()) {
            return Collections.emptyList();
        }

        List<SongResponse> resultData = new ArrayList<>();
        songListTables.forEach(table -> {
            table.findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr"))
                .stream()
                .filter(tr -> tr.findElements(By.tagName("td")).size() == 5)
                .filter(tr -> {
                    List<WebElement> tdList = tr.findElements(By.tagName("td"));
                    if (tdList.get(0).getText().trim().equals("번호") ||
                        tdList.get(1).getText().trim().equals("곡명")
                    ) {
                        return false;
                    }
                    return true;
                })
                .forEach(
                    tr -> {
                        List<WebElement> tdList = tr.findElements(By.tagName("td"));
                        String songTitle = tdList.get(1).getText();
                        if (ObjectUtils.isEmpty(songTitle) || !StringUtils.hasText(songTitle)) {
                            return;
                        }
                        String songCode = tdList.get(0).getText();
                        String songArtist = tdList.get(2).getText();
                        resultData.add(new SongResponse(songTitle, songArtist, songCode, ""));
                    }
                );
        });

        return resultData;
    }
}

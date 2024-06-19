package com.example.jong1.infra.craw;


import com.example.jong1.infra.song.SongResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Component
@RequiredArgsConstructor
public class NamuWikiCraw extends AbstractSongCrawling {

    @Override
    public List<SongResponse> process(String url) {
        WebDriver webDriver = CrawlingCommonOptions.ofCommonChromeDriver();

        try {
            return getDataList(webDriver, url);
        } catch (InterruptedException e) {
            log.error("Thread interrupted", e);
            throw new RuntimeException("Thread interrupted", e);
        }catch (UnhandledAlertException e) {
            log.error("[{}] 유효하지 않은 URL >>> {}", this.getClass().getName(), url);
            throw new IllegalArgumentException("유효하지 않은 URL");
        } finally {
            webDriver.close();
            webDriver.quit();
        }
    }

    private List<SongResponse> getDataList(WebDriver webDriver, String url) throws InterruptedException {
        webDriver.get(url);
        Thread.sleep(3000);
        List<WebElement> songListTables = webDriver.findElements(By.className("As04+zbd"));
//        List<WebElement> songListTables = webDriver.findElements(By.className("QnwRzcjS"));

        if (songListTables.isEmpty()) {
            return Collections.emptyList();
        }

        List<SongResponse> resultData = new ArrayList<>();
        songListTables.forEach(div -> {
            div.findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr"))
                .stream().filter(tr -> !StringUtils.hasText(tr.getAttribute("style")))
                .forEach(
                    tr -> {
                        List<WebElement> tdList = tr.findElements(By.tagName("td"));
                        String songCode = tdList.get(0).getText();
                        String songTitle = tdList.get(1).getText();
                        String songArtist = tdList.get(2).getText();
                        String songRelease = tdList.get(4).getText();
                        resultData.add(new SongResponse(songTitle, songArtist, songCode, songRelease));
                    }
                );
        });
        return resultData;
    }
}

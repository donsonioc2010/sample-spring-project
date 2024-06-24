package com.example.jong1.infra.craw;

import com.example.jong1.infra.song.SongResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Slf4j
public abstract class AbstractSongCrawling {

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

    protected abstract List<SongResponse> getDataList(WebDriver webDriver, String url) throws InterruptedException;
}

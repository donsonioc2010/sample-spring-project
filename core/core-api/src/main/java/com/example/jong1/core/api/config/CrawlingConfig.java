package com.example.jong1.core.api.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CrawlingConfig {

    private static final String DRIVER_KEY = "webdriver.chrome.driver";

    @Value("${chrome.driver.path}")
    private String chromeDriverPath;

    @PostConstruct
    public void init() {
        log.info("[{}] ChromeDriverPath >>> {}", this.getClass().getName(), chromeDriverPath);
        System.setProperty(DRIVER_KEY, chromeDriverPath);
    }
}

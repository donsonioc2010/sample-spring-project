package com.example.jong1.infra.craw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CrawlingCommonOptions {
    public static WebDriver ofCommonChromeDriver() {
        return new ChromeDriver(ofCommonChromeOptions());
    }

    public static ChromeOptions ofCommonChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // 브라우저를 켜지 않고 크롤링
//        options.setCapability("browserVersion", "126.0.6478.62");
        options.addArguments("--remote-allow-origins=*");

        return options;
    }
}

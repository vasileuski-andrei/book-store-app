package com.idf.service;

import com.idf.page.BasePage;
import com.idf.page.HomePage;
import com.idf.page.UndefinedPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class NavigationService {

    private WebDriver driver;
    private Map<String, BasePage> pageUrl;

    public NavigationService(WebDriver driver) {
        this.driver = driver;
        pageUrl = new HashMap();
        pageUrl.put("https://demoqa.com/", new HomePage());
    }

    public <T extends BasePage> T openPage(String url) {
        driver.get(url);
        log.info("Page " + url + " opened");

        if (pageUrl.containsKey(url)) {
            return (T) pageUrl.get(url);
        }
        return (T) new UndefinedPage();
    }

    public Boolean isWebsiteCorrect() {
        return driver.getTitle().equals("DEMOQA");
    }

}

package com.idf.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='home-body']//div[6]")
    private WebElement bookStoreApplication;

    public BookStoreApplicationPage openBookStorePage() {
        waitingForEvents.waitForAppearanceElement(bookStoreApplication);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 250)");
        bookStoreApplication.click();
        log.info("BookStoreApplicationPage was opened");

        return new BookStoreApplicationPage();
    }
}

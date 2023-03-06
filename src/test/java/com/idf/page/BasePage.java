package com.idf.page;

import com.idf.driver.DriverSingleton;
import com.idf.waits.WaitingForEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {

    protected WebDriver driver;
    protected WaitingForEvents waitingForEvents;
    protected static final Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        waitingForEvents = new WaitingForEvents(driver);
    }

}

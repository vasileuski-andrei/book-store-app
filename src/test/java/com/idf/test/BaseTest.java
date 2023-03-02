package com.idf.test;

import com.idf.driver.DriverSingleton;
import com.idf.page.BookStoreApplicationPage;
import com.idf.page.HomePage;
import com.idf.page.LoginPage;
import com.idf.page.ProfilePage;
import com.idf.service.NavigationService;
import com.idf.service.ParserService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected BookStoreApplicationPage bookStoreApplicationPage;
    protected LoginPage loginPage;
    protected ProfilePage profilePage;
    protected NavigationService navigationService;
    protected ParserService parserService;
    public static final String USERNAME = "Andrei";
    public static final String PASSWORD = "Test123@";

    @BeforeMethod
    public void setup() {
        driver = DriverSingleton.getDriver();
        navigationService = new NavigationService(driver);
        parserService = new ParserService();
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        DriverSingleton.closeDriver();
    }

}

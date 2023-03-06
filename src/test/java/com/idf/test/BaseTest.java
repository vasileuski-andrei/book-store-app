package com.idf.test;

import com.idf.driver.DriverSingleton;
import com.idf.page.BookStoreApplicationPage;
import com.idf.page.HomePage;
import com.idf.page.LoginPage;
import com.idf.page.ProfilePage;
import com.idf.service.NavigationService;
import com.idf.service.ApiService;
import com.idf.service.TestDataReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected BookStoreApplicationPage bookStoreApplicationPage;
    protected LoginPage loginPage;
    protected ProfilePage profilePage;
    protected NavigationService navigationService;
    protected ApiService apiService;

    public String username = null;
    public final String password = TestDataReader.getTestData("testdata.user.password");

    public static final String CREATE_USER_API_URL = "https://demoqa.com/Account/V1/User";
    public static final String ALL_BOOKS_API_URL = "https://demoqa.com/BookStore/V1/Books";

    @BeforeClass
    public void setupPreconditions() {
        apiService = new ApiService();
        username = apiService.createNewUserThroughApi(CREATE_USER_API_URL, password);
    }

    @BeforeMethod
    public void setup() {
        driver = DriverSingleton.getDriver();
        navigationService = new NavigationService(driver);
        checkWebsite();
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        DriverSingleton.closeDriver();
    }

    private void checkWebsite() {
        homePage = navigationService.openPage("https://demoqa.com/");

        assertTrue(navigationService.isWebsiteCorrect());
    }

}

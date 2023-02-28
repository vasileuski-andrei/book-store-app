package com.idf.test;

import com.idf.model.Book;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class BookStoreTest extends BaseTest {

    @Test
    public void isLoginSuccessful() {

        String userName = "Andrei";
        String password = "Test123@";

        homePage = navigationService.openPage("https://demoqa.com/");
        Assert.assertTrue(navigationService.isWebsiteCorrect());

        bookStoreApplicationPage = homePage.openBookStorePage();
        loginPage = bookStoreApplicationPage.openLoginPage();
        loginPage.inputCredentials(userName, password);
        profilePage = loginPage.clickLoginButton();

        Assert.assertTrue(profilePage.isProfilePageOpened());

    }

    @Test
    public void areTheListOfBooksMatch() throws IOException {
        List<Book> books = parserService.getDataFromApi("https://demoqa.com/BookStore/V1/Books");
        homePage = navigationService.openPage("https://demoqa.com/");

        Assert.assertTrue(navigationService.isWebsiteCorrect());

        bookStoreApplicationPage = homePage.openBookStorePage();

        Assert.assertTrue(bookStoreApplicationPage.isBooksMatch(books));

    }

}

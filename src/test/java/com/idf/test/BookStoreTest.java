package com.idf.test;

import com.idf.model.Book;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

public class BookStoreTest extends BaseTest {

    @Test
    public void isLoginSuccessful() {

        homePage = navigationService.openPage("https://demoqa.com/");
        assertTrue(navigationService.isWebsiteCorrect());

        boolean actualResult = homePage
                .openBookStorePage()
                .openLoginPage()
                .inputCredentials(USERNAME, PASSWORD)
                .clickLoginButton()
                .isProfilePageOpened();

        assertTrue(actualResult, "Profile Page wasn't opened");

    }

    @Test
    public void areTheListOfBooksMatch() throws IOException {
        List<Book> books = parserService.getDataFromApi("https://demoqa.com/BookStore/V1/Books");
        homePage = navigationService.openPage("https://demoqa.com/");

        assertTrue(navigationService.isWebsiteCorrect());

        bookStoreApplicationPage = homePage.openBookStorePage();

        assertTrue(bookStoreApplicationPage.isBooksMatch(books), "List of books aren't equal each other");

    }

}

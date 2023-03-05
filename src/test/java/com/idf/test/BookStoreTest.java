package com.idf.test;

import com.idf.model.Book;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class BookStoreTest extends BaseTest {

    @Test
    public void isLoginSuccessful() {

        boolean actualResult = homePage
                .openBookStorePage()
                .openLoginPage()
                .inputCredentials(username, password)
                .clickLoginButton()
                .isProfilePageOpened();

        assertTrue(actualResult, "Profile Page wasn't opened");

    }

    @Test
    public void areTheListOfBooksMatch() throws IOException {
        List<Book> books = apiService.getDataFromApi(ALL_BOOKS_API_URL);

        bookStoreApplicationPage = homePage.openBookStorePage();

        assertTrue(bookStoreApplicationPage.isBooksMatch(books), "List of books aren't equal each other");

    }

}

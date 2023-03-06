package com.idf.page;

import com.idf.model.Book;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class BookStoreApplicationPage extends BasePage {

    @FindBy(xpath = "//li[@id='item-0']/span[text()='Login']")
    private WebElement login;

    @FindBy(xpath = "//div[@class='rt-tbody']")
    private WebElement booksContainer;

    public LoginPage openLoginPage() {
        waitingForEvents.waitForAppearanceElementAndClick(login);
        log.info("LoginPage was opened");
        return new LoginPage();
    }

    public boolean isBooksMatch(List<Book> apiBooks) {
        waitingForEvents.waitForAppearanceElement(booksContainer);
        String uiBooks = booksContainer.getText();

        for (Book apiBook : apiBooks) {
            if (!uiBooks.contains(apiBook.getTitle())) return false;
        }
        log.info("List of books from api and ui are equal each other");

        return true;
    }


}

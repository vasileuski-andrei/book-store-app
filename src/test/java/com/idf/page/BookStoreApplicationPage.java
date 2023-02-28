package com.idf.page;

import com.idf.model.Book;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class BookStoreApplicationPage extends BasePage {

    @FindBy(xpath = "//div[@class='left-pannel']//div[@class='element-group'][6]//ul[@class='menu-list']/li[@id='item-0']")
    private WebElement login;

    @FindBy(xpath = "//div[@class='rt-tbody']")
    private WebElement booksContainer;

    public LoginPage openLoginPage() {
        waitingForEvents.waitForAppearanceElementAndClick(login);
        logger.info("LoginPage was opened");
        return new LoginPage();
    }

    public boolean isBooksMatch(List<Book> apiBooks) {
        waitingForEvents.waitForAppearanceElement(booksContainer);
        String uiBooks = booksContainer.getText();

        for (Book apiBook : apiBooks) {
            if (!uiBooks.contains(apiBook.getTitle())) return false;
        }
        return true;
    }


}

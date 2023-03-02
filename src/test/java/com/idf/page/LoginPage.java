package com.idf.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='userName']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='login']")
    private WebElement loginButton;

    public void inputCredentials(String userName, String password) {
        waitingForEvents.waitForAppearanceElementAndClick(userNameField);
        userNameField.sendKeys(userName);

        waitingForEvents.waitForAppearanceElementAndClick(passwordField);
        passwordField.sendKeys(password);
        logger.info("Credentials were inserted");
    }

    public ProfilePage clickLoginButton() {
        waitingForEvents.waitForAppearanceElementAndClick(loginButton);
        logger.info("ProfilePage was opened");
        return new ProfilePage();
    }
}

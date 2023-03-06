package com.idf.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "userName")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    public LoginPage inputCredentials(String userName, String password) {
        waitingForEvents.waitForAppearanceElementAndClick(userNameField);
        userNameField.sendKeys(userName);

        waitingForEvents.waitForAppearanceElementAndClick(passwordField);
        passwordField.sendKeys(password);
        log.info("Credentials were inserted");

        return this;
    }

    public ProfilePage clickLoginButton() {
        waitingForEvents.waitForAppearanceElementAndClick(loginButton);
        log.info("ProfilePage was opened");

        return new ProfilePage();
    }
}

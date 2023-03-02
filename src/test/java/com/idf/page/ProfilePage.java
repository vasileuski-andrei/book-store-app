package com.idf.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//div[@class='main-header'][.='Profile']")
    private WebElement headerProfile;

    public boolean isProfilePageOpened() {
        try {
            waitingForEvents.waitForAppearanceElementAndClick(headerProfile);
        } catch (Exception e) {
            logger.info(e);
            return false;
        }

        return true;
    }


}

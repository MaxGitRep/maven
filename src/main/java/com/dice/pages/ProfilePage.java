package com.dice.pages;

import com.dice.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePageObject<ProfilePage> {

    private By accountSettings = By.tagName("h1");
    private By emailText = By.xpath("//div[@id='unav']//strong");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void waitForProfilePageLoad(){
        waitForVisibilityOf(accountSettings);
        waitForVisibilityOf(emailText);
    }

    public boolean isCorrectProfileLoaded (String correctProfileName){
        if (getText(emailText).equals(correctProfileName)){
            return true;
        }
        return false;
    }

}

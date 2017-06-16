package com.dice.pages;

import com.dice.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject<LoginPage>{

    private static final String URL = "https://secure.indeed.com/account/login";

    private By emailField = By.xpath("//input[@id='signin_email']");
    private By passField = By.xpath("//input[@id='signin_password']");
    private By signInButton = By.xpath("//Button[@type='submit']");
    private By errorMessage = By.xpath("//div[@id='signin_password_grp']//*[@class='control-error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage(){
        getPage(URL);
        waitForVisibilityOf(signInButton);
    }

    public void fillUpEmailPass (String email, String pass){
        type(email, emailField);
        type(pass, passField);
    }

    public ProfilePage pushSignInButton(){
        click(signInButton);
        return new ProfilePage(driver);
    }

    public String getLoginErrorMessage() {
        waitForVisibilityOf(errorMessage, 10);
        return getText(errorMessage);
    }
}

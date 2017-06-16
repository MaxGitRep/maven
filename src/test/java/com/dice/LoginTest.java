package com.dice;

import com.dice.base.BaseTest;
import com.dice.base.CsvDataProvider;
import com.dice.pages.LoginPage;
import com.dice.pages.ProfilePage;

import org.testng.annotations.*;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.testng.Assert.*;


public class LoginTest extends BaseTest{

    //@Description("1.1 - positive login")
    @Test (priority = 1, groups = {"positive"})
    public void positiveLoginTest(){
        String expectedTitle1 = "Sign In | Indeed Accounts";
        String expectedTitle2 = "Account settings | Indeed Accounts";
        String userEmail = "gratis.mpa@gmail.com";
        String userPassword = "123456qwert";

        LoginPage loginPage = new LoginPage(driver);
        //open login page https://secure.indeed.com/account/login
        loginPage.openLoginPage();

        log.info("Verify title");
        String actualTitle1 = loginPage.getTitle();
        assertTrue(expectedTitle1.equals(actualTitle1),
                "Page title is not expected. \nExpected: " + expectedTitle1 + "\nActual: " + actualTitle1);

        //fill up email and pass
        log.info("Fill up email and pass");
        loginPage.fillUpEmailPass(userEmail, userPassword);

        //push Sing In and wait
        log.info("Push Sing In");
        ProfilePage profilePage = loginPage.pushSignInButton();
        log.info("Waiting visibility account settings");
        profilePage.waitForProfilePageLoad();

        //Verify title and email
        log.info("Verify title and email");
        String actualTitle2 = profilePage.getTitle();
        //Assert.assertTrue(expectedTitle2.equals(actualTitle2),
        //        "Page title is not expected. \nExpected: " + expectedTitle2 + "\nActual: " + actualTitle2);
        assertThat(actualTitle2, is(equalTo(expectedTitle2)));
        assertTrue(profilePage.isCorrectProfileLoaded(userEmail), "Profile name is not correct");

    }

    //@Description("1.2 - negative login")
    @Test (dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class,
            priority = 2, groups = {"negative"})
    public void negativeLoginTest(Map<String, String> testData){
        String expectedError = "Incorrect password or email address";
        String testNumber = testData.get("no");
        String userEmail = testData.get("email");
        String userPassword = testData.get("password");
        String description = testData.get("description");

        log.info("Test# " + testNumber + " for " + description);

        LoginPage loginPage = new LoginPage(driver);
        //open login page https://secure.indeed.com/account/login
        loginPage.openLoginPage();

        //fill up email and pass
        loginPage.fillUpEmailPass(userEmail, userPassword);

        //push Sing In
        loginPage.pushSignInButton();

        log.info("Verify error message");
        String actualErrorMessage = loginPage.getLoginErrorMessage();
        //assertTrue(actualErrorMessage.contains(expectedError),
        //        "Error message is not expected.Expected: " + expectedError + "\nActual: " + actualErrorMessage);
        assertThat(actualErrorMessage, containsString(expectedError));

    }

}

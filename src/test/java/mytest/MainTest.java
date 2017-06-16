package mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by mpa on 4/20/2017.
 */
public class MainTest {
    protected WebDriverWait wait;
    //@Test
    public void SearchJobAndCheck() throws Exception {
        System.out.println("Start");
        PrepareTest prepare_test = new PrepareTest();
        WebDriver startBrowser = prepare_test.startBrowser("firefox");

        SearchTest checkSearchFunctionality = new SearchTest(startBrowser)
                .openMainPage("http://indeed.co.uk")
                .addSearchData("Selenium", "London");

        assertEquals(checkSearchFunctionality.getCheckSearchCount(), "Jobs 1 to 10 of 800");
        assertEquals(checkSearchFunctionality.getCheckSearchTitle(), "Selenium Jobs, vacancies in London | Indeed.co.uk");
        System.out.println("Finish");
    }
    //@Test
    public void registrationForm() throws Exception{
        WebDriver startFF = new PrepareTest().startBrowser("firefox");
        new SearchTest(startFF).openMainPage("http://www.facebook.com");

        WebElement monthSelector = startFF.findElement(By.id("month"));
        Select monthDragNDrop = new Select(monthSelector);
        monthDragNDrop.selectByVisibleText("May");


    }

}

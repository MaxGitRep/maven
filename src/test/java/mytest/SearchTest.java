package mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Created by mpa on 4/20/2017.
 */
public class SearchTest {
    private final WebDriver driver;

    public SearchTest (WebDriver driver){
        this.driver = driver;
    }

    @FindBy(id = "what")
    public WebElement searchField;

    @FindBy (id = "where")
    public WebElement searchLocation;

    @FindBy (id = "fj")
    public WebElement buttonFindJob;

    @FindBy (id = "prime-popover-close-button")
    public WebElement popupPrime;


    public SearchTest openMainPage(String urlOpenPage){
        driver.get(urlOpenPage);
        initElements(driver, this);
        return this;
    }

    public SearchTest addSearchData(String what, String where) throws Exception {
        searchField.sendKeys(what);
        searchLocation.sendKeys(where);
        buttonFindJob.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //popupPrime.click();
        return this;
    }

    public String getCheckSearchTitle() {
        return driver.getTitle();
    }

    public String getCheckSearchCount() {
        return driver.findElement(By.id("searchCount")).getText();
    }
}

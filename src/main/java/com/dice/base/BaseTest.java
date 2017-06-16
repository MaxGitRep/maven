package com.dice.base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;

    @BeforeClass(alwaysRun = true)
    protected void setUpClass(ITestContext ctx){
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);
    }

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    protected void methodSetUp(@Optional("firefox") String browser){
        log.info("Set Up");
        driver = BrowserFactory.getDriver(browser, log);
    }

    @AfterMethod(alwaysRun = true)
    protected void methodTearDown(){
        log.info("Tear Down");
        //driver.close();
        driver.quit();
    }

}

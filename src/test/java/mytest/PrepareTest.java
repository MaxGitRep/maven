package mytest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by mpa on 4/20/2017.
 */
public class PrepareTest {

    static WebDriver driver;

    //@BeforeClass
    public WebDriver startBrowser(String browserName) throws Exception {
        if (browserName.equals("firefox")) {
            //System.setProperty("webdriver.gecko.driver", "C:/UnitTest/geckodriver-v0.15.0-win64/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", "C:/UnitTest/geckodriver-v0.14.0-win64/geckodriver.exe");
            //Create Firefox Driver with Marionette capabilities
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            driver = new FirefoxDriver(capabilities);

        } else if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:/UnitTest/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equals("ie")) {
            System.setProperty("webdriver.ie.driver", "C:/UnitTest/IEDriverServer_x64_3.3.0/IEDriverServer.exe");
            driver = new InternetExplorerDriver();

        } else if (browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "C:/UnitTest/Edge_3.14393/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();

        } else {
            System.out.println("NO Such Browser");
        }

        driver.manage().window().maximize();
        return driver;
    }

    //@AfterSuite
    public void quitBrowser() {
        driver.quit();
    }

    //@Test
    public void test2() throws Exception {
        startBrowser("edge");
        System.out.println("Test Start 2");


    }
}

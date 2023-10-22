package Step_Difination;
import Utilties.Constants;
import Utilties.JSONReader;
import com.google.gson.JsonObject;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//driver manger and base class
public class Hooks extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    static JsonObject jsonData = JSONReader.readJSONFile();




    public static WebDriver getDriver() {
    if (driver == null) {

        String browser = System.getProperty("browser", Constants.BROWESR);
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--disable-page-visibility-checks");
                chromeOptions.addArguments("--disable-javascript");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // Disable the "Chrome is being controlled by automated test software" notification

                WebDriverManager.chromedriver().setup();


                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }


    driver.navigate().to(Constants.BASE_URL);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));




    return driver;
    }


    public static void quitDriver() {

        if (driver != null) {
     driver.quit();
            driver = null;
        }
    }
    public static boolean isBrowserOpen() {
        return driver != null;
}
}


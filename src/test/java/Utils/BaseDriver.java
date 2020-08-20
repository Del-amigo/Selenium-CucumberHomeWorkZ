package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class BaseDriver {
    private static WebDriver driver;
    private static Actions builder;
    private static JavascriptExecutor js;
    private static SoftAssert softAssert;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            builder = new Actions(driver);
            js = (JavascriptExecutor) driver;
            softAssert = new SoftAssert();
            driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

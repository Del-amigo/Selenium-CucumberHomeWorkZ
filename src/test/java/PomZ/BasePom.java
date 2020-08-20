package PomZ;

import Utils.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePom {
    protected WebDriverWait wait;
    protected WebDriver driver;

    public BasePom() {
        driver = BaseDriver.getDriver();
        wait = new WebDriverWait( driver, 10);
        PageFactory.initElements( driver,this );
    }

    public void waitAndSendKeys(WebElement locator, String text) {
        try {
            WebElement webElement = wait.until( ExpectedConditions.visibilityOf( locator ) );
            webElement.clear();
            webElement.sendKeys( text );
        }catch (NullPointerException nullPoint){
            System.out.println(nullPoint.getMessage());
        }
    }

    public void waitAndClick(WebElement locator) {
        WebElement webElement = wait.until( ExpectedConditions.visibilityOf( locator ) );
        webElement.click();
    }

    public WebElement elementToBeClickable (WebElement webElement){
        return wait.until( ExpectedConditions.elementToBeClickable(webElement) );
    }
}

package PomZ;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TablePom extends BasePom {

    public TablePom() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[id*='username']")
    public WebElement usernameInputElement;
    @FindBy(css = "[id*='password']")
    public WebElement passwordInputElement;
    @FindBy(css = "[id*='login_button']")
    public WebElement loginButtonElement;
    @FindBy(css = "[class='selected']")
    public WebElement viewAllOrdersElement;
    @FindBy(xpath = "//a[text()='View all products']")
    public WebElement viewAllProductsElement;
    @FindBy(css = "[name*='OrderSelector']")
    public List<WebElement> AllOrdersListElement;

}

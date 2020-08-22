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
    @FindBy(xpath = "//a[text()='Order']")
    public WebElement orderElement;
    @FindBy(css = "[name*='OrderSelector']")
    public List<WebElement> AllOrdersListElement;
    @FindBy(xpath = "//a[text()='Check All']")
    public WebElement checkAllButton;
    @FindBy(css = "[class='btnDeleteSelected']")
    public WebElement deleteAllButton;
    @FindBy(css = "[id*=_txtName]")
    public WebElement customerNameInputElement;
    @FindBy(xpath = "//select[contains(@id,'_ddlProduct')]")
    public WebElement productSelectorElement;
    @FindBy(css = "[id*=_TextBox2]")
    public WebElement streetInputElement;
    @FindBy(css = "[id*=_TextBox3]")
    public WebElement cityInputElement;
    @FindBy(css = "[id*=_TextBox4]")
    public WebElement stateInputElement;
    @FindBy(css = "[id*=_TextBox5]")
    public WebElement zipInputElement;
    @FindBy(css = "[id*=r_cardList_0]")
    public WebElement cardRadioElement;
    @FindBy(css = "[id*=_TextBox6]")
    public WebElement cardNumberInputElement;
    @FindBy(css = "[id*=_TextBox1]")
    public WebElement expirationDateElement;
}

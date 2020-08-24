package PomZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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
    @FindBy(xpath = "//a[text()='View all orders']")
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
    @FindBy(css = "[id*='_txtQuantity']")
    public WebElement quantityInputElement;
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
    @FindBy(css = "[id*='_InsertButton']")
    public WebElement processSubmitButton;
    @FindBy(xpath = "//strong[contains(text(),'successfully added')]")
    public WebElement successMessage;

    public String getText(int num) {
        String value = "";
        switch (num) {
            case 0:
                value = productSelectorElement.getAttribute( "value" );
                break;
            case 1:
                value = streetInputElement.getAttribute( "value" );
                break;
            case 2:
                value = cityInputElement.getAttribute( "value" );
                break;
            case 3:
                value = stateInputElement.getAttribute( "value" );
                break;
            case 4:
                value = zipInputElement.getAttribute( "value" );
                break;
            case 5:
                value = cardRadioElement.getAttribute( "value" );
                break;
            case 6:
                value = cardNumberInputElement.getAttribute( "value" );
                break;
            case 7:
                value = expirationDateElement.getAttribute( "value" );
                break;
            default:
                Assert.fail(value + " not implemented for search fields");
        }
        return value;
    }

    public boolean findErrorNextTo(String errorIn) {
        WebElement errorText;
        switch (errorIn){
            case "Quantity":
                errorText = driver.findElement( By.xpath( "//span[contains(text(),'Quantity must be greater than zero.')]" ) );
                break;
            case "CustomerName":
                errorText = driver.findElement( By.xpath( "//span[contains(text(),'Field 'Customer name' cannot be empty.')]" ) );
                break;
            case "Street":
                errorText = driver.findElement( By.xpath( "//span[contains(text(),\"Field 'Street' cannot be empty.\")]" ) );
                break;
            case "City":
                errorText = driver.findElement( By.xpath( "//span[contains(text(),\"Field 'City' cannot be empty.\")]" ) );
                break;
            case "Zip":
                errorText = driver.findElement( By.xpath( "//span[contains(text(),\"Field 'Zip' cannot be empty.\")]" ) );
                break;
            case "CardNumber":
                errorText = driver.findElement( By.xpath( "//span[contains(text(),\"Field 'Card Nr' cannot be empty.\")]" ) );
                break;
            case "ExpireDate":
                errorText = driver.findElement( By.xpath( "//span[contains(text(),'Field 'Expire date' cannot be empty.')]" ) );
                break;
            default:
                throw new NullPointerException( "Unexpected value: " + errorIn );
        }
        return errorText.isDisplayed();
    }

    public void sendKeysToField(String field, String value) {
        WebElement fieldElement = getFieldElement(field);
        waitAndSendKeys(fieldElement, value);
    }

    private WebElement getFieldElement(String field) {
        WebElement element = null;
        switch (field) {
            case "Quantity":
                element = quantityInputElement;
                break;
            case "CustomerName":
                element = customerNameInputElement;
                break;
            case "Street":
                element = streetInputElement;
                break;
            case "City":
                element = cityInputElement;
                break;
            case "State":
                element = stateInputElement;
                break;
            case "Zip":
                element = zipInputElement;
                break;
            case "CardNumber":
                element = cardNumberInputElement;
                break;
            case "ExpireDate":
                element = expirationDateElement;
                break;
            default:
                Assert.fail(field + " not implemented for search fields");
        }
        return element;
    }
}

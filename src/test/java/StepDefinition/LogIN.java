package StepDefinition;

import PomZ.TablePom;
import Utils.ThreadLocalBaseDriver;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class LogIN {
    TablePom page = new TablePom();
    private WebDriver driver;

    @Given("^I navigate to \"([^\"]*)\"$")
    public void iNavigateTo(String website){
        driver = ThreadLocalBaseDriver.getDriver();
        driver.manage().window().maximize();
        driver.get( website );
        driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );
    }
    @When("^I try try to login using Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void i_try_try_to_login_using_Username_as_and_Password_as(String username, String password){
        page.waitAndSendKeys( page.usernameInputElement, username);
        page.waitAndSendKeys( page.passwordInputElement, password);
        page.waitAndClick( page.loginButtonElement );
    }

    @Then("^I am logged in$")
    public void i_am_logged_in(){
      page.elementToBeClickable( page.viewAllOrdersElement );
    }

    @When("^I entered to a \"([^\"]*)\" screen$")
    public void i_entered_to_a_screen(String screenName) {
        switch (screenName) {
            case "View all orders":
                page.waitAndClick( page.viewAllOrdersElement );
                break;
            case "View all products":
                page.waitAndClick( page.viewAllProductsElement );
                break;
            case "Order":
                page.waitAndClick( page.orderElement );
                break;
            default:
                throw new IllegalStateException( "Unexpected value: " + screenName );
        }
    }
}

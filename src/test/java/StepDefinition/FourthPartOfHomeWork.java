package StepDefinition;

import PomZ.TablePom;
import Utils.BaseDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.List;

public class FourthPartOfHomeWork {
    private WebDriver driver;
    TablePom page = new TablePom();
    private String text;

    @When("^Verify the data of the \"([^\"]*)\"$")
    public void verify_the_data_of_the(String info) {
        driver = BaseDriver.getDriver();
        page.waitAndClick( driver.findElement( By.xpath( "//td[text()='" + info + "']//following::input" ) ) );
        Assert.assertEquals( page.customerNameInputElement.getAttribute( "value" ), info, info + " -did not found!" );
    }

    @Then("^Data should be as following:$")
    public void data_should_be_as_following(DataTable table) {
        List<String> strings = table.asList( String.class );
            boolean value1 = strings.get( 0 ).equalsIgnoreCase( page.productSelectorElement.getAttribute( "value" )  );
            boolean value2 = strings.get( 1 ).equalsIgnoreCase( page.streetInputElement.getAttribute( "value" ) );
            boolean value3 = strings.get( 2 ).equalsIgnoreCase( page.cityInputElement.getAttribute( "value" ) );
            boolean value4 = strings.get( 3 ).equalsIgnoreCase( page.stateInputElement.getAttribute( "value" ) );
            boolean value5 = strings.get( 4 ).equalsIgnoreCase( page.zipInputElement.getAttribute( "value" ) );
            boolean value6 = strings.get( 5 ).equalsIgnoreCase( page.cardRadioElement.getAttribute( "value" ) );
            boolean value7 = strings.get( 6 ).equalsIgnoreCase( page.cardNumberInputElement.getAttribute( "value" ) );
            boolean value8 = strings.get( 7 ).equalsIgnoreCase( page.expirationDateElement.getAttribute( "value" ) );
            System.out.println( (value1 && value2 && value3 && value4 && value5 && value6 && value7 && value8) ? "Everything is OK" : "Something went wrong" );
    }
}

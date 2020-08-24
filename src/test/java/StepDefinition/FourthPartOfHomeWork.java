package StepDefinition;

import PomZ.TablePom;
import Utils.ThreadLocalBaseDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.List;

public class FourthPartOfHomeWork {
    private WebDriver driver;
    TablePom page = new TablePom();

    @When("^Verify the data of the \"([^\"]*)\"$")
    public void verify_the_data_of_the(String info) {
        driver = ThreadLocalBaseDriver.getDriver();
        page.waitAndClick( driver.findElement( By.xpath( "//td[text()='" + info + "']//following::input" ) ) );
        Assert.assertEquals( page.customerNameInputElement.getAttribute( "value" ), info, info + " -did not found!" );
    }

    @Then("^Data should be as following:$")
    public void data_should_be_as_following(DataTable table) {
        List<String> strings = table.asList( String.class );
        for (int i = 0; i < strings.size(); i++) {
            Assert.assertEquals( strings.get( i ), page.getText( i ) );
        }
    }
}

package StepDefinition;

import PomZ.TablePom;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class SecondPartOfHomeWork {
    TablePom page = new TablePom();
    WebDriver driver;

    @And("^I create order with arbitary fields:$")
    public void iCreateOrderWithArbitaryFields(DataTable fields){
        Map<String, String> fieldsMap = fields.asMap(String.class, String.class);
        for (String field : fieldsMap.keySet()) {
            page.sendKeysToField(field, fieldsMap.get(field));
        }
        page.waitAndClick(page.cardRadioElement); // Visa Card*
        page.waitAndClick( page.processSubmitButton );
    }

    @Then("^Order is successfully added$")
    public void orderIsSuccessfullyAdded() {
        boolean displayed = page.successMessage.isDisplayed();
        System.out.println((displayed) ? "New order created" : " Something went wrong");
    }

    @Then("^Create an orders with different product Type in the dropdown$")
    public void createAnOrdersWithDifferentProductTypeInTheDropdown(DataTable table) {
//        WebElement element = driver.findElement( By.xpath( "//tr[2]//td[13]//input[1]" ) );
        List<String> raw = table.asList( String.class );
        for (String s : raw) {
            page.dropdownSelectorByText( page.productSelectorElement, s );
            //           page.updateSubmitButton.click();
            try {
                Thread.sleep( 3000 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

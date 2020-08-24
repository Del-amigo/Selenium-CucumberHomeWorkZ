package StepDefinition;

import PomZ.TablePom;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import java.util.Map;

public class SecondPartOfHomeWork {
    TablePom page = new TablePom();

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

}

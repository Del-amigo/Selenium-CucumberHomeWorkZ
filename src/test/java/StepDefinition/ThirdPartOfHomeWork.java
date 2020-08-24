package StepDefinition;

import PomZ.TablePom;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.testng.Assert;
import java.util.List;
import java.util.Map;

public class ThirdPartOfHomeWork {
    TablePom page = new TablePom();

    @When("^I try to fill in with following data:$")
    public void iTryToFillInWithFollowingData(DataTable fields) {
        List<Map<String, String>> maps = fields.asMaps( String.class, String.class );
        for (Map<String, String> fieldMap : maps) {
            page.waitAndSendKeys(page.quantityInputElement,fieldMap.get( "Quantity" ));
            page.waitAndSendKeys(page.customerNameInputElement,fieldMap.get( "CustomerName" ) );
            page.waitAndSendKeys(page.streetInputElement,fieldMap.get( "Street" ));
            page.waitAndSendKeys(page.cityInputElement,fieldMap.get( "City" ) );
            page.waitAndSendKeys(page.stateInputElement,fieldMap.get( "State" )  );
            page.waitAndSendKeys(page.zipInputElement,fieldMap.get( "Zip" ) );
            page.waitAndSendKeys(page.cardNumberInputElement,fieldMap.get( "CardNumber" ) );
            page.waitAndSendKeys(page.expirationDateElement,fieldMap.get( "ExpireDate" ) );

//            boolean errorExists = page.findErrorNextTo( fieldMap.get( "ErrorNextTo" ) );
//            Assert.assertEquals( errorExists,!fieldMap.get( "ErrorNextTo" ).isEmpty(),"Expected error in " + fieldMap.get("errorIn") + " to exist!" );
        }
    }
}

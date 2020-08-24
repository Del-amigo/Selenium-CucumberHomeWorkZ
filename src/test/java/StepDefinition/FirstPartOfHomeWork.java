package StepDefinition;

import PomZ.TablePom;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import org.testng.Assert;
import java.util.List;
import java.util.Map;


public class FirstPartOfHomeWork {
    TablePom page = new TablePom();

    @When("^Verify items are displayed$")
    public void verify_items_are_displayed(DataTable table){
        List<Map<String, String>> mapList = table.asMaps( String.class, String.class );
        for (Map<String, String> row : mapList) {
            int size = page.AllOrdersListElement.size();
            String expected = row.get( "Expected" );
            Assert.assertEquals(Integer.parseInt( expected ),size);
        }
    }

    @When("^I delete all items from the table$")
    public void i_delete_all_items_from_the_table(){
      page.waitAndClick( page.checkAllButton );
      page.waitAndClick( page.deleteAllButton );
    }
}

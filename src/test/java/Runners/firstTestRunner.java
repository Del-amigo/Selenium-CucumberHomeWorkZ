package Runners;

import Utils.ThreadLocalBaseDriver;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;

@CucumberOptions(
        plugin = { "html:target/cucumber-report",
                "com.cucumber.listener.ExtentCucumberFormatter:target/extent_report/index.html"},
        features = {"src/test/java/FeatureFiles/CucucmberSecond_HW_01.feature"},
        glue = {"StepDefinition"}
)
public class firstTestRunner extends AbstractTestNGCucumberTests {
    @Parameters("browser")
    @BeforeClass
    public void configureBrowser(@Optional("chrome") String browser) {
        ThreadLocalBaseDriver.setBrowser(browser);
    }
    @AfterClass
    public void quiteDriver() {
        ThreadLocalBaseDriver.quitDriver();
    }

    @AfterClass
    public void configReport(){
        Reporter.loadXMLConfig("src/test/java/Runners/report.xml");
    }
}

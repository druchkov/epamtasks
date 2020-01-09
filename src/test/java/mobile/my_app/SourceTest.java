package mobile.my_app;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import testing_of_mobile.FunctionForMobile;
import testing_of_mobile.driver.DriverSetup;
import testing_of_mobile.my_app.BracketPageObject;

import java.net.MalformedURLException;

public class SourceTest {
    BracketPageObject page;

    @BeforeTest
    public void setup() {
        try {
            new DriverSetup().getDriver("bracket");
        } catch (MalformedURLException exp) {
            exp.printStackTrace();
        }
        page = new BracketPageObject();
    }

    @AfterTest
    public void killDriver() {
        new FunctionForMobile().killDriver();
    }
}

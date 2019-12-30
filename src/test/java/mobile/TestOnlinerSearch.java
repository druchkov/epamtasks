package mobile;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import testing_of_mobile.driver.DriverSetup;
import testing_of_mobile.FunctionForMobile;

import java.net.MalformedURLException;

public class TestOnlinerSearch extends FunctionForMobile {

    @BeforeTest
    public void setup() {
        try {
            new DriverSetup().getDriver("onliner");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void closeDriver() {
        killDriver();
    }

    @Test(description = "Check that the firs Iphone 8 plus costs 1350 p")
    public void searchInOnliner() {
        String idLocator = "by.onliner.catalog:id/";
        By loupeLocator = By.id(idLocator + "menu_search");
        By searchFieldLocator = By.id(idLocator + "search_src_text");
        By resultCostLocator = By.id(idLocator + "text_prices");
        waitWebElement(loupeLocator).click();
        waitWebElement(searchFieldLocator).sendKeys("Iphone 8 plus");
        String resultCost = waitWebElement(resultCostLocator).getText();
        Assert.assertEquals(resultCost, "от 1350,00 р.", "Cost should be 'от 1350,00 р.'");
    }
}

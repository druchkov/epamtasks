package testing_of_mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testing_of_mobile.driver.DriverSetup;

import java.net.MalformedURLException;


public class FunctionForMobile  {
    private static final int WAITING_TIME = 10;

    public WebElement waitWebElement(By by) throws MalformedURLException {
        return new WebDriverWait(new DriverSetup().getDriver(), WAITING_TIME)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public void killDriver() throws MalformedURLException {
        new DriverSetup().getDriver().quit();
    }
}

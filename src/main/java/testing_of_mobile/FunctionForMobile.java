package testing_of_mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testing_of_mobile.driver.DriverSetup;

import java.net.MalformedURLException;


public class FunctionForMobile {
    private static final int WAITING_TIME = 10;

    public WebElement waitWebElement(By by) throws MalformedURLException {
        return new WebDriverWait(new DriverSetup().getDriver(), WAITING_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitWebElementToClickable(By by) throws MalformedURLException {
        return new WebDriverWait(new DriverSetup().getDriver(), WAITING_TIME)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public void clickOnButton(By by) throws MalformedURLException {
        waitWebElementToClickable(by).click();
    }

    public boolean isButtonEnabled(By by) throws MalformedURLException {
        return waitWebElement(by).isEnabled();
    }

    public void typeText(By by, String text) throws MalformedURLException {
        WebElement element = waitWebElement(by);
        element.click();
        element.sendKeys(text);
    }

    public String getTextElement(By by) throws MalformedURLException {
        return waitWebElement(by).getText();
    }

    public void killDriver() throws MalformedURLException {
        new DriverSetup().getDriver().quit();
    }
}

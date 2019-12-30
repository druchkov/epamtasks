package testing_of_mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testing_of_mobile.driver.DriverSetup;


public class FunctionForMobile {
    private static final int WAITING_TIME = 10;

    public WebElement waitWebElement(By by) {
        return new WebDriverWait(new DriverSetup().getDriver(), WAITING_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitWebElementToClickable(By by) {
        return new WebDriverWait(new DriverSetup().getDriver(), WAITING_TIME)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public void clickOnButton(By by) {
        waitWebElementToClickable(by).click();
    }

    public boolean isButtonEnabled(By by) {
        return waitWebElement(by).isEnabled();
    }

    public void typeText(By by, String text) {
        WebElement element = waitWebElement(by);
        element.click();
        element.sendKeys(text);
    }

    public String getTextElement(By by) {
        return waitWebElement(by).getText();
    }

    public void killDriver() {
        new DriverSetup().getDriver().quit();
    }
}

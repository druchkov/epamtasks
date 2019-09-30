package webdriver.screen.cloud;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Browser {
    protected final int WAITING_TIME = 10;
    protected final int WAITING_EMAIL = 200;
    protected WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver switchToFrame(By by) {
        return new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    protected WebDriver switchToDefault() {
        return driver.switchTo().defaultContent();
    }

    protected WebElement waitElement(By by) {
        return new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected List<WebElement> waitAllElements(By by) {
        return new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public Browser createNewWindow() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        return this;
    }

    public Browser switchBetweenTwoTabs() {
        String startPage = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();
        String[] stringTabs = new String[tabs.size()];
        tabs.toArray(stringTabs);
        if (stringTabs[0].equals(startPage)) {
            driver.switchTo().window(stringTabs[1]);
        } else {
            driver.switchTo().window(stringTabs[0]);
        }
        return this;
    }
}

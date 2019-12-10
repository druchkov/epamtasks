package webdriver.browser;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.driver.DriverManager;

import java.util.Set;

public class Browser {
    private static final int WAITING_TIME = 10;
    private static WebDriver driver;

    public Browser() {
        if (driver == null) {
            this.driver = DriverManager.getDriver();
        }
    }

    public WebElement waitWebElement(By by) {
        return new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private void clearField(By by) {
        waitWebElement(by).click();
        waitWebElement(by).sendKeys(Keys.chord(Keys.CONTROL + "a"));
    }

    private String highlightFieldBeforeType(By by) {
        WebElement element = waitWebElement(by);
        String bgColor = element.getCssValue("BackgroundColor");
        JavascriptExecutor jsE = (JavascriptExecutor) driver;
        jsE.executeScript("arguments[0].style.backgroundColor = '" + "blue" + "'", element);
        return bgColor;
    }

    private void removeHighlightAfterType(By by, String oldBackgroundColor) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor jsE = (JavascriptExecutor) driver;
        jsE.executeScript("arguments[0].style.backgroundColor = '" + oldBackgroundColor + "'", element);
    }

    private void highlightBorderButtonBeforeClick(By by) {
        WebElement element = driver.findElement(by);
        String border = element.getCssValue("border");
        JavascriptExecutor jsE = (JavascriptExecutor) driver;
        jsE.executeScript("arguments[0].style.border='3px solid blue'", element);
        jsE.executeScript("arguments[0].style.border='" + border + "'", element);

    }

    public Browser createNewWindow() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        return this;
    }

    protected WebDriver switchToFrame(By by) {
        return new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    protected WebDriver switchToDefaultContext() {
        return driver.switchTo().defaultContent();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void typeText(By by, String text) {
        String oldBackgroundColor = highlightFieldBeforeType(by);
        waitWebElement(by).sendKeys(text);
        removeHighlightAfterType(by, oldBackgroundColor);
    }

    public void typeTextWithPreliminaryClearField(By by, String text) {
        clearField(by);
        typeText(by, text);
    }

    public void clickOnButton(By by) {
        WebElement element = waitWebElement(by);
        highlightBorderButtonBeforeClick(by);
        element.click();
    }

    public void moveItemInOtherItem(By sourceItem, By target) {
        new Actions(driver)
                .dragAndDrop(waitWebElement(sourceItem), waitWebElement(target))
                .build()
                .perform();
    }

    public void contextClick(By by) {
        new Actions(driver)
                .contextClick(waitWebElement(by))
                .build()
                .perform();
    }

    public Browser switchBetweenTwoTabs() {
        String startPage = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();
        String[] stringTabs = tabs.toArray(new String[tabs.size()]);
        if (stringTabs[0].equals(startPage)) {
            driver.switchTo().window(stringTabs[1]);
        } else {
            driver.switchTo().window(stringTabs[0]);
        }
        return this;
    }
}

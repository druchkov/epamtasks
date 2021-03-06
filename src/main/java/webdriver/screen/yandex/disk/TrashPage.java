package webdriver.screen.yandex.disk;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.util.Log;

public class TrashPage extends YandexDiskPage {

    private static final By CLEAR_TRASH_MAIN_BUTTON_LOCATOR = By.
            xpath("//div[@class='listing-head__additional-actions']/button");
    private static final By HINT_LOCATOR = By.xpath("//div[@class ='notifications__text js-message']");
    private static final By AREA_TRASH_LOCATOR = By.xpath("//div[@class='listing-item__info']" +
            "/ancestor::div[contains(@class, 'listing-item')]");

    public EmptyTrashWindow clickOnClearTrash() {
        browser.clickOnButton(CLEAR_TRASH_MAIN_BUTTON_LOCATOR);
        Log.info("Click on empty trash");
        return new EmptyTrashWindow();
    }

    public boolean isClearTrashButtonEnabled() {
        return browser.waitWebElement(CLEAR_TRASH_MAIN_BUTTON_LOCATOR).isEnabled();
    }

    public boolean isTrashEmpty() {
        try {
        return new WebDriverWait(browser.getDriver(), 1)
                .until(ExpectedConditions.visibilityOfElementLocated(AREA_TRASH_LOCATOR))
                .isDisplayed();
        } catch (TimeoutException exc) {
            return false;
        }
    }

    public TrashPage waitHint() {
        browser.waitWebElement(HINT_LOCATOR);
        return this;
    }

}

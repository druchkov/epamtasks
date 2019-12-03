package webdriver.screen.yandex.disk;

import org.openqa.selenium.By;
import webdriver.browser.Browser;
import webdriver.util.Log;

public class EmptyTrashWindow {

    private static Browser browser;
    private static final By EMPTY_TRASH_LOCATOR = By.xpath("//div[@class='b-confirmation__buttons']" +
            "/button[contains(@class,'js-confirmation-accept')]");
    private static final By CANCEL_BUTTON_LOCATOR = By.xpath("//div[@class='b-confirmation__buttons']" +
            "/button[contains(@class,'js-confirmation-cancel')]");

    public EmptyTrashWindow() {
        if(browser == null) {
            browser = new Browser();
        }
    }

    public TrashPage emptyTrash() {
        browser.clickOnButton(EMPTY_TRASH_LOCATOR);
        Log.info("Trash was cleared");
        return new TrashPage();
    }

    public TrashPage cancelEmpty() {
        browser.clickOnButton(CANCEL_BUTTON_LOCATOR);
        Log.info("Trash wasn't cleared");
        return new TrashPage();
    }
}

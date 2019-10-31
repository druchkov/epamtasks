package webdriver.screen.yandex.disk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.browser.Browser;

public class YandexDiskPage {
    private static final By BUTTON_CREATE_LOCATOR = By.xpath("//div[@class = 'sidebar__buttons']//button");
    private static final By BUTTON_CREATE_NEW_FOLDER_LOCATOR = By.xpath("//span[contains(@class,'file-icon_dir_plus')]/..");
    private static final By FIELD_FOR_CREATE_NEW_NAME_FILE_LOCATOR =
            By.xpath("//form[@class = 'rename-dialog__rename-form']//input");
    private static final By BUTTON_SAVE_LOCATOR = By.xpath("//div[@class = 'dialog__body']//button");
    private static final By TRASH_LOCATOR = By.xpath("//div[contains(@class, 'js-prevent-drag')]");
    private static final By FIELD_ITEMS_LOCATOR = By.xpath("//div[@class = 'client-listing']");
    private static final By NEW_FOLDER_FROM_CONTEXT_MENU_LOCATOR =
            By.xpath("//div[@class = 'menu__group']/div[contains(@class, '_new-folder')]");
    Browser browser;

    public YandexDiskPage(WebDriver driver) {
        if (browser == null) {
            browser = new Browser(driver);
        }
    }

    private By createLocatorForFilesByName(String name) {
        String locator = String.
                format("//span[text() = '%s']/ancestor::div[contains(@class, 'listing-item_size_m')]", name);
        return By.xpath(locator);
    }

    public YandexDiskPage createNewFolder(String nameFolder) {
        browser.clickOnButton(BUTTON_CREATE_LOCATOR);
        browser.clickOnButton(BUTTON_CREATE_NEW_FOLDER_LOCATOR);
        browser.typeTextWithPreliminaryClearField(FIELD_FOR_CREATE_NEW_NAME_FILE_LOCATOR, nameFolder);
        browser.clickOnButton(BUTTON_SAVE_LOCATOR);
        return this;
    }

    public YandexDiskPage moveFileInTresh(String nameFile) {
        browser.moveItemInOtherItem(createLocatorForFilesByName(nameFile), TRASH_LOCATOR);
        return this;
    }

    public YandexDiskPage createFolderFromContextMenu(String nameFolder) {
        browser.contextClick(FIELD_ITEMS_LOCATOR);
        browser.clickOnButton(NEW_FOLDER_FROM_CONTEXT_MENU_LOCATOR);
        browser.typeTextWithPreliminaryClearField(FIELD_FOR_CREATE_NEW_NAME_FILE_LOCATOR, nameFolder);
        browser.clickOnButton(BUTTON_SAVE_LOCATOR);
        return this;
    }

    public boolean isFileExist(String name) {
        return new WebDriverWait(browser.getDriver(), 1)
                .until(ExpectedConditions.visibilityOfElementLocated(createLocatorForFilesByName(name)))
                .isDisplayed();
    }
}

package webdriver.screen.yandex.disk;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.util.Log;
import webdriver.browser.Browser;

public class YandexDiskPage {
    private static final By BUTTON_CREATE_LOCATOR = By.xpath("//div[@class = 'sidebar__buttons']//button");
    private static final By BUTTON_CREATE_NEW_FOLDER_LOCATOR = By.xpath("//span[contains(@class,'file-icon_dir_plus')]/..");
    private static final By FIELD_FOR_CREATE_NEW_NAME_FILE_LOCATOR =
            By.xpath("//form[@class = 'rename-dialog__rename-form']//input");
    private static final By SAVE_BUTTON_LOCATOR = By.xpath("//div[@class = 'dialog__body']//button");
    private static final By TRASH_LOCATOR = By.xpath("//div[contains(@class, 'js-prevent-drag')]");
    private static final By FIELD_ITEMS_LOCATOR = By.xpath("//div[@class = 'client-listing']");
    private static final By NEW_FOLDER_FROM_CONTEXT_MENU_LOCATOR =
            By.xpath("//div[@class = 'menu__group']/div[contains(@class, '_new-folder')]");
    private static final By HIND_LOCATOR = By.xpath("//div[@class = 'notifications__text js-message']");
    protected static final By LINK_TRASH_LOCATOR = By.xpath("//a[@href ='/client/trash']");
    protected static Browser browser;

    public YandexDiskPage() {
        if (browser == null) {
            browser = new Browser();
        }
    }

    protected By createLocatorForFilesByName(String name) {
        String locator = String.
                format("//span[text() = '%s']/ancestor::div[contains(@class, 'listing-item_size_m')]", name);
        return By.xpath(locator);
    }

    public YandexDiskPage clickOnCreateItem() {
        browser.clickOnButton(BUTTON_CREATE_LOCATOR);
        Log.info("Clicked on create button");
        return this;
    }

    public YandexDiskPage clickOnCreateNewFolder() {
        browser.clickOnButton(BUTTON_CREATE_NEW_FOLDER_LOCATOR);
        Log.info("clicked on create folder");
        return this;
    }

    public YandexDiskPage typeNewNameItem(String name) {
        browser.typeTextWithPreliminaryClearField(FIELD_FOR_CREATE_NEW_NAME_FILE_LOCATOR, name);
        Log.info(String.format("Typed: %s name folder", name));
        return this;
    }

    public YandexDiskPage clickOnSaveButton() {
        browser.clickOnButton(SAVE_BUTTON_LOCATOR);
        Log.info("New folder created");
        return this;
    }

    public YandexDiskPage clickOnNewFolderFromContext() {
        browser.contextClick(FIELD_ITEMS_LOCATOR);
        Log.info("Context menu opened");
        browser.clickOnButton(NEW_FOLDER_FROM_CONTEXT_MENU_LOCATOR);
        Log.info("Clicked on 'new folder'");
        return this;
    }

    public TrashPage clickOnTrashLink() {
        browser.clickOnButton(LINK_TRASH_LOCATOR);
        Log.info("Click on Trash link");
        return new TrashPage();
    }

    public YandexDiskPage moveFileInTrash(String nameFile) {
        Log.info("try remove " + nameFile);
        browser.moveItemInOtherItem(createLocatorForFilesByName(nameFile), TRASH_LOCATOR);
        browser.waitWebElement(HIND_LOCATOR);
        Log.info("file " + nameFile + " removed");
        return this;
    }

    public boolean isFileExist(String name) {
        try {
            return new WebDriverWait(browser.getDriver(), 1)
                    .until(ExpectedConditions.visibilityOfElementLocated(createLocatorForFilesByName(name)))
                    .isDisplayed();
        } catch (TimeoutException exc) {
            return false;
        }
    }

    public boolean isPageOpened() {
        return browser.waitWebElement(BUTTON_CREATE_LOCATOR).isEnabled();
    }
}

package webdriver.yandex.disk;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.browser.BrowserFactory;
import webdriver.browser.TypeBrowser;
import webdriver.screen.yandex.disk.YandexDiskLoginPageObject;
import webdriver.screen.yandex.disk.YandexDiskPageObject;

public class CreateNewFolderInYandexDiskTest {
    String login = "qaAutomationGomel";
    String password = "gomelQa";
    String nameFolder = "test";
    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = BrowserFactory.getBrowser(TypeBrowser.CHROME);
    }

    @AfterTest
    public void quit() {
        new YandexDiskPageObject(driver).moveFileInTresh(nameFolder);
        driver.quit();
    }

    @Test
    public void createNewFolderTest() {
        new YandexDiskLoginPageObject(driver)
                .openPage()
                .typeLogin(login)
                .clickOnLogin()
                .typePassword(password)
                .clickOnLogin();
       YandexDiskPageObject yandexDiskPage = new YandexDiskPageObject(driver);
        yandexDiskPage.createNewFolder(nameFolder);
        Assert.assertTrue(yandexDiskPage.isFileExist(nameFolder));
    }
}

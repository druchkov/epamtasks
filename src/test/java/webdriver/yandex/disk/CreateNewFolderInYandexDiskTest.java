package webdriver.yandex.disk;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdriver.browser.BrowserFactory;
import webdriver.browser.TypeBrowser;
import webdriver.screen.yandex.disk.LoginPage;
import webdriver.screen.yandex.disk.YandexDiskPage;

public class CreateNewFolderInYandexDiskTest {
    String login = "qaAutomationGomel";
    String password = "gomelQa";
    String nameFolder = "test";
    WebDriver driver;

    @BeforeTest(description = "get driver from BrowserFactory")
    public void getDriver() {
        driver = BrowserFactory.getBrowser(TypeBrowser.CHROME);
    }

    @AfterTest(description = "remove folder after test")
    public void moveFileInTrash() {
        new YandexDiskPage(driver).moveFileInTresh(nameFolder);
    }

    @AfterClass(description = "destroy driver")
    public void quiteDriver() {
        driver.quit();
    }

    @Test(description = "create new folder and assert what new folder exist")
    public void createNewFolder() {
        new LoginPage(driver)
                .open()
                .typeLogin(login)
                .clickOnLogin()
                .typePassword(password)
                .clickOnLogin();
        YandexDiskPage yandexDiskPage = new YandexDiskPage(driver);
        yandexDiskPage.createNewFolder(nameFolder);
        Assert.assertTrue(yandexDiskPage.isFileExist(nameFolder));
    }

    @Test(description = "try find not exist folder", expectedExceptions = NoSuchElementException.class)
    public void findNotExistFile() {
        new LoginPage(driver)
                .open()
                .typeLogin(login)
                .clickOnLogin()
                .typePassword(password)
                .clickOnLogin();
        YandexDiskPage yandexDiskPage = new YandexDiskPage(driver);
        Assert.assertTrue(yandexDiskPage.isFileExist("1234"));
    }
}

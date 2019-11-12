package webdriver.yandex.disk;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.factory.BrowserFactory;
import webdriver.browser.TypeBrowser;
import webdriver.screen.yandex.disk.LoginPage;
import webdriver.screen.yandex.disk.YandexDiskPage;

public class CreateNewFolderWithContextClickForLinux extends SourceTest{
    String nameFolder = "test";

    @BeforeTest(description = "set up driver for work on linux")
    public void setup() {
        driver = BrowserFactory.getBrowserForSauceLabs(TypeBrowser.CHROME, "LINUX", "48");
    }

    @AfterTest(description = "remove created folder")
    public void moveCreatedFileInTrashAndQuitDriver() {
        new YandexDiskPage(driver).moveFileInTrash(nameFolder);
    }

    @AfterClass(description = "kill driver")
    public void quiteDriver() {
        driver.quit();
    }

    @Test(description = "create new folder with context click")
    public void createNewFolderWithContextClick() {
        new LoginPage(driver)
                .open()
                .login(user);
        YandexDiskPage pageObject = new YandexDiskPage(driver);
                pageObject.createFolderFromContextMenu(nameFolder);
        Assert.assertTrue(pageObject.isFileExist(nameFolder) );
    }
}

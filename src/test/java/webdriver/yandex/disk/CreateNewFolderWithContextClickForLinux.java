
package webdriver.yandex.disk;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.factory.BrowserFactory;
import webdriver.browser.TypeBrowser;
import webdriver.factory.UserYandexDiskFactory;
import webdriver.screen.yandex.disk.LoginPage;
import webdriver.screen.yandex.disk.YandexDiskPage;
import webdriver.service.disk.YandexDiskServices;

public class CreateNewFolderWithContextClickForLinux extends SourceTest{
    String nameFolder = "test";

    @BeforeTest(description = "set up driver for work on linux")
    public void setup() {
        driver = BrowserFactory.getBrowserForSauceLabs(TypeBrowser.CHROME, "LINUX", "48");
    }

    @AfterTest(description = "remove created folder")
    public void moveCreatedFileInTrashAndQuitDriver() {
        new YandexDiskPage().moveFileInTrash(nameFolder);
    }

    @AfterClass(description = "kill driver")
    public void quiteDriver() {
        driver.quit();
    }

    @Test(description = "create new folder with context click")
    public void createNewFolderWithContextClick() {

        UserYandexDiskFactory.withCredentialsFromProperty();
        YandexDiskServices.createNewFolderFromContextMenu(nameFolder);
        boolean isFileExist = new YandexDiskPage().isFileExist(nameFolder);
        Assert.assertTrue(isFileExist, "File wasn't found");
    }
}
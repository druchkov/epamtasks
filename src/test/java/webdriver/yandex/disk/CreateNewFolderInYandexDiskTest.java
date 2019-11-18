package webdriver.yandex.disk;

import org.testng.Assert;
import org.testng.annotations.*;
import webdriver.screen.yandex.disk.LoginPage;
import webdriver.screen.yandex.disk.YandexDiskPage;

public class CreateNewFolderInYandexDiskTest extends SourceTest {
    String nameFolder = "test";

    @AfterClass(description = "remove folder after test")
    public void moveFileInTrash() {
        new YandexDiskPage(driver).moveFileInTrash(nameFolder);
    }

    @Test(description = "create new folder and assert what new folder exist")
    public void createNewFolder() {
        boolean fileExist = new LoginPage(driver)
                .open()
                .login(user)
                .createNewFolder(nameFolder)
                .isFileExist(nameFolder);
        Assert.assertTrue(fileExist, "File " + nameFolder + " not found");
    }
}

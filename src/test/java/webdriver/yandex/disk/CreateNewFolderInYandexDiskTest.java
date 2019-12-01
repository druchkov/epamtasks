package webdriver.yandex.disk;

import org.testng.Assert;
import org.testng.annotations.*;
import webdriver.screen.yandex.disk.YandexDiskPage;
import webdriver.service.disk.YandexDiskServices;

public class CreateNewFolderInYandexDiskTest extends SourceTest {
    String nameFolder = "test";

    @AfterClass(description = "remove folder after test")
    public void moveFileInTrash() {
        new YandexDiskPage().moveFileInTrash(nameFolder);
    }

    @Test(description = "create new folder and assert what new folder exist")
    public void createNewFolder() {
        boolean fileExist = YandexDiskServices.createNewFolder(nameFolder)
                .isFileExist(nameFolder);
        Assert.assertTrue(fileExist, "File " + nameFolder + " not found");
    }
}

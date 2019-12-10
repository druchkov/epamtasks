package webdriver.yandex.disk;

import org.testng.Assert;
import org.testng.annotations.Test;
import webdriver.screen.yandex.disk.TrashPage;
import webdriver.service.disk.YandexDiskTrashServices;

public class EmptyTrashTest extends SourceTest {

    @Test(description = "Clear all files from trash")
    public void emptyTrash() {
        YandexDiskTrashServices.moveInTrashAndClearTrash();
        boolean isTrashEmpty = new TrashPage().isTrashEmpty();
        Assert.assertTrue(isTrashEmpty, "Trash should be empty");
    }
}

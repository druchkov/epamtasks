package webdriver.yandex.disk;

import org.testng.Assert;
import org.testng.annotations.Test;
import webdriver.service.disk.YandexDiskTrashServices;

public class EmptyTrashTest extends SourceTest {

    @Test
    public void emptyTrash() {
       boolean isTrashEmpty = YandexDiskTrashServices.emptyTrash().isTrashEmpty();
        Assert.assertTrue(isTrashEmpty, "Trash should be empty");
    }
}

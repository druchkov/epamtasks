package webdriver.service.disk;

import webdriver.screen.yandex.disk.TrashPage;
import webdriver.screen.yandex.disk.YandexDiskPage;

public class YandexDiskTrashServices {

    private static YandexDiskPage trashPage = new TrashPage();

    public static TrashPage emptyTrash() {
        return trashPage.clickOnTrashLink()
                .clickOnClearTrash()
                .emptyTrash()
                .waitHint();
    }
}

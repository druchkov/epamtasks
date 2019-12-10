package webdriver.service.disk;

import webdriver.screen.yandex.disk.TrashPage;
import webdriver.screen.yandex.disk.YandexDiskPage;

public class YandexDiskTrashServices {

    private static YandexDiskPage trashPage = new TrashPage();

    public static void moveInTrashAndClearTrash() {
        new YandexDiskPage().clickOnTrashLink()
                .clickOnClearTrash()
                .emptyTrash()
                .waitHint();
    }

    public static void clearTrash() {
        new TrashPage().
                clickOnClearTrash()
                .emptyTrash()
                .waitHint();
    }
}

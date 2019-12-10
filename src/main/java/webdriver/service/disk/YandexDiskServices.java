package webdriver.service.disk;

import webdriver.screen.yandex.disk.YandexDiskPage;

public class YandexDiskServices {
    public static void createNewFolder(String nameFolder) {
        new YandexDiskPage().clickOnCreateItem()
                .clickOnCreateNewFolder()
                .typeNewNameItem(nameFolder)
                .clickOnSaveButton();
    }

    public static void createNewFolderFromContextMenu(String nameFolder) {
        new YandexDiskPage().clickOnNewFolderFromContext()
                .typeNewNameItem(nameFolder)
                .clickOnSaveButton();
    }
}
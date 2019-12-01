package webdriver.service.disk;

import webdriver.screen.yandex.disk.YandexDiskPage;

public class YandexDiskServices {

    private static YandexDiskPage diskPage = new YandexDiskPage();

    public static YandexDiskPage createNewFolder(String nameFolder) {
        diskPage.clickOnCreateItem()
                .clickOnCreateNewFolder()
                .typeNewNameItem(nameFolder)
                .clickOnButtonSave();
        return diskPage;
    }

    public static YandexDiskPage createNewFolderFromContextMenu(String nameFolder) {
        diskPage.clickOnNewFolderFromContextClick()
                .typeNewNameItem(nameFolder)
                .clickOnButtonSave();
        return diskPage;
    }
}
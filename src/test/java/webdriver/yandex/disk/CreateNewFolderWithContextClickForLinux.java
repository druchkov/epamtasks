package webdriver.yandex.disk;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.browser.BrowserFactory;
import webdriver.browser.TypeBrowser;
import webdriver.screen.yandex.disk.LoginPage;
import webdriver.screen.yandex.disk.YandexDiskPage;

public class CreateNewFolderWithContextClickForLinux {
    String sauceUserName = "d.druchkov";
    String sauceAccessKey = "fdf2abf5-fc5e-4a81-899b-5a9e7f230ed5";
    String url = "https://" + sauceUserName + ":" + sauceAccessKey + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    WebDriver driver;
    String nameFolder = "test";


    @BeforeTest(description = "set up driver for work on linux")
    public void setup() {
        driver = BrowserFactory.getBrowserForSauceLabs(TypeBrowser.CHROME, "LINUX", "48");
    }

    @AfterTest(description = "remove created folder")
    public void moveCreatedFileInTrashAndQuitDriver() {
        new YandexDiskPage(driver).moveFileInTresh(nameFolder);
    }

    @AfterClass(description = "kill driver")
    public void quiteDriver() {
        driver.quit();
    }

    @Test(description = "create new folder with context click")
    public void createNewFolderWithContextClick() {
        new LoginPage(driver)
                .open()
                .typeLogin("qaAutomationGomel")
                .clickOnLogin()
                .typePassword("gomelQa")
                .clickOnLogin();
        YandexDiskPage pageObject = new YandexDiskPage(driver);
                pageObject.createFolderFromContextMenu(nameFolder);
        Assert.assertTrue(pageObject.isFileExist(nameFolder) );
    }
}

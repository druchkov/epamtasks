package webdriver.yandex.disk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.screen.yandex.disk.YandexDiskLoginPageObject;
import webdriver.screen.yandex.disk.YandexDiskPageObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CreateNewFolderWithContextClickForLinuxTest {
    String sauceUserName = "d.druchkov";
    String sauceAccessKey = "fdf2abf5-fc5e-4a81-899b-5a9e7f230ed5";
    String url = "https://" + sauceUserName + ":" + sauceAccessKey + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    WebDriver driver;
    String nameFolder = "test";


    @BeforeTest
    public void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("username", sauceUserName);
        capabilities.setCapability("accessKey", sauceAccessKey);
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("platform", "LINUX");
        capabilities.setVersion("48");

        try {
            driver = new RemoteWebDriver(new URL(url), capabilities);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void quit() {
        new YandexDiskPageObject(driver).moveFileInTresh(nameFolder);
        driver.quit();
    }

    @Test
    public void createNewFolderWithContextClickTest() {
        new YandexDiskLoginPageObject(driver)
                .openPage()
                .typeLogin("qaAutomationGomel")
                .clickOnLogin()
                .typePassword("gomelQa")
                .clickOnLogin();
        YandexDiskPageObject pageObject = new YandexDiskPageObject(driver);
                pageObject.createFolderFromContextMenu(nameFolder);
        Assert.assertTrue(pageObject.isFileExist(nameFolder) );
    }
}

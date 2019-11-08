package webdriver.yandex.disk;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import webdriver.driver.DriverManager;
import webdriver.model.UserYandexDisk;
import webdriver.service.UserYandexDiskCreator;
import webdriver.util.TestListener;

@Listeners({TestListener.class})
public class SourceTest {
    protected WebDriver driver;
    protected UserYandexDisk user = UserYandexDiskCreator.withCredentialsFromProperty();

    @BeforeTest
    public void setup() {
        driver = DriverManager.getDriver();
    }

    @AfterTest
    public void quiteDriver() {
        DriverManager.quiteDriver();
    }
}

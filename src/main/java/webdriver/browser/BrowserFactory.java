package webdriver.browser;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    private static final String URL_HUB = "http://localhost:4444/wd/hub";

    public static WebDriver getBrowser(TypeBrowser browser) {
        WebDriver driver = null;
        DesiredCapabilities desiredCapabilities;
        switch (browser) {
            case CHROME:
                desiredCapabilities = DesiredCapabilities.chrome();
                desiredCapabilities.setVersion("78");
                desiredCapabilities.setPlatform(Platform.WINDOWS);
                try {
                    driver = new RemoteWebDriver(new URL(URL_HUB), desiredCapabilities);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case OPERA:
                desiredCapabilities = DesiredCapabilities.operaBlink();
                desiredCapabilities.setBrowserName("opera");
                try {
                    driver = new RemoteWebDriver(new URL(URL_HUB), desiredCapabilities);
                    driver = new OperaDriver();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case FIREFOX:
                desiredCapabilities = DesiredCapabilities.firefox();
                try {
                    driver = new RemoteWebDriver(new URL(URL_HUB), desiredCapabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                throw new IllegalArgumentException();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        return driver;
    }

}

package webdriver.browser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    private static final String URL_HUB = "http://localhost:4444/wd/hub";
    private static WebDriver driver = null;
    private static Logger logger = LogManager.getRootLogger();

    private BrowserFactory() {}

    public static WebDriver getBrowser(TypeBrowser browser) {
        switch (browser) {
            case CHROME:
                try {
                    driver = new RemoteWebDriver(new URL(URL_HUB), setUpChrome("78", Platform.WINDOWS));
                } catch (Exception e) {
                    logger.error(e);
                }
                break;
            case OPERA:
                try {
                    driver = new RemoteWebDriver(new URL(URL_HUB), setUpOpera("64", Platform.WINDOWS));
                } catch (Exception e) {
                    logger.error(e);
                }
                break;
            case FIREFOX:
                try {
                    driver = new RemoteWebDriver(new URL(URL_HUB), setUpFireFox("70", Platform.WINDOWS));
                } catch (MalformedURLException e) {
                    logger.error(e);
                }
                break;
            default:
                throw new IllegalArgumentException();
        }
        configureDriver();
        return driver;
    }

    public static WebDriver getBrowserForSauceLabs(TypeBrowser browser, String platform, String version) {
        String sauceUserName = "d.druchkov";
        String sauceAccessKey = "fdf2abf5-fc5e-4a81-899b-5a9e7f230ed5";
        String url = "https://" + sauceUserName + ":" + sauceAccessKey +
                "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("username", sauceUserName);
        capabilities.setCapability("accessKey", sauceAccessKey);
        capabilities.setCapability("browserName", browser.getNameBrowser());
        capabilities.setCapability("platform", platform);
        capabilities.setVersion(version);
        try {
            driver = new RemoteWebDriver(new URL(url), capabilities);
        } catch (MalformedURLException e) {
            logger.error(e);
        }
        configureDriver();
        return driver;
    }

    private static void configureDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    private static DesiredCapabilities setUpChrome(String version, Platform platform) {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setVersion(version);
        capabilities.setPlatform(platform);
        return capabilities;
    }

    private static DesiredCapabilities setUpFireFox(String version, Platform platform) {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setVersion(version);
        capabilities.setPlatform(platform);
        return capabilities;
    }

    private static DesiredCapabilities setUpOpera(String version, Platform platform) {
        DesiredCapabilities capabilities = DesiredCapabilities.operaBlink();
        capabilities.setVersion(version);
        capabilities.setPlatform(platform);
        capabilities.setBrowserName("opera");
        return capabilities;
    }
}

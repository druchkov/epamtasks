package testing_of_mobile.driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {

    private static AndroidDriver driver;

    private DesiredCapabilities setCapability() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "R58M65JJN2P");
        capabilities.setCapability("platformName", "Android");
        File app = new File("src/main/resources/onliner.apk");
        capabilities.setCapability("app", app.getAbsolutePath());
        return capabilities;
    }

    public AndroidDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), setCapability());
        }
        return driver;
    }
}

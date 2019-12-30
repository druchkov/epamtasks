package testing_of_mobile.driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {

    private static AndroidDriver driver;

    public AndroidDriver getDriver() {
        return driver;
    }

    public AndroidDriver getDriver(String apkName) throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("platformName", "Android");
            File app = new File(String.format("src/main/resources/%s.apk", apkName));
            capabilities.setCapability("app", app.getAbsolutePath());
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }
        return driver;
    }
}

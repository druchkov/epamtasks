package testing_of_mobile.service;

import org.openqa.selenium.remote.DesiredCapabilities;
import testing_of_mobile.util.PropertyReader;

import java.io.File;

public class PropertyForMobileFactory {
    private static final String PLATFORM_NAME = "platform.name";
    private static final String DEVICE_NAME =  "device.name";
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    private PropertyForMobileFactory() {}

    private static void setupPlatform() {
        capabilities.setCapability("deviceName", PropertyReader.getData(DEVICE_NAME));
        capabilities.setCapability("platformName", PropertyReader.getData(PLATFORM_NAME));
    }

    public static DesiredCapabilities getCapabilitiesOnliner() {
        setupPlatform();
        File app = new File("src/main/resources/onliner.apk");
        capabilities.setCapability("app", app.getAbsolutePath());
        return capabilities;
    }

    public static DesiredCapabilities getCapabilitiesBracket() {
        setupPlatform();
        File app = new File("src/main/resources/bracket.apk");
        capabilities.setCapability("app", app.getAbsolutePath());
        return capabilities;
    }
}

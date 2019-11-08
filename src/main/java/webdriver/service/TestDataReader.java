package webdriver.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    private TestDataReader() {}

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}

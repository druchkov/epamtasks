package testing_of_mobile.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties property = new Properties();

    private PropertyReader() throws IOException {
        FileInputStream stream = new FileInputStream("src/main/resources/mobile.properties");
        property.load(stream);
    }

    public static String getData(String key) {
        return property.getProperty(key);
    }
}

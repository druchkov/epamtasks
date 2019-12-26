package testing_of_mobile.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties property = new Properties();

    private PropertyReader() throws IOException {
        property.load(new FileReader("src/main/resources/mobile.properties"));
    }

    public static String getData(String key) {
        return property.getProperty(key);
    }
}

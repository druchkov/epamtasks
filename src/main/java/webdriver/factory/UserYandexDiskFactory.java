package webdriver.factory;

import webdriver.model.UserYandexDisk;
import webdriver.service.TestDataReader;

public class UserYandexDiskFactory {
    private static final String TESTDATA_USER_NAME = "testdata.user.name";
    private static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    private UserYandexDiskFactory() {}

    public static UserYandexDisk withCredentialsFromProperty() {
        return  new UserYandexDisk(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }
}

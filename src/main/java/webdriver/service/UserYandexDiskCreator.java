package webdriver.service;

import webdriver.model.UserYandexDisk;

public class UserYandexDiskCreator {
    private static final String TESTDATA_USER_NAME = "testdata.user.name";
    private static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    private UserYandexDiskCreator() {}

    public static UserYandexDisk withCredentialsFromProperty() {
        return  new UserYandexDisk(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }
}

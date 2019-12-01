package webdriver.factory;

import webdriver.model.UserYandexDiskBuilder;
import webdriver.model.UserYandexDisk;
import webdriver.service.TestDataReader;

public class UserYandexDiskFactory {
    private static final String TESTDATA_USER_NAME = "testdata.user.name";
    private static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    private UserYandexDiskFactory() {
    }

    public static UserYandexDisk withCredentialsFromProperty() {
        return withAnyCredentials(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static UserYandexDisk withAnyCredentials(String login, String password) {
        return new UserYandexDiskBuilder()
                .setLogin(login)
                .setPassword(password)
                .build();
    }

    public static UserYandexDisk withEmptyPassword(String login) {
        return withAnyCredentials(login, "");
    }

    public static UserYandexDisk withEmptyLogin(String password) {
        return withAnyCredentials("", password);
    }
}

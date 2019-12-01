package webdriver.model;

public class UserYandexDiskBuilder {

    private UserYandexDisk user = new UserYandexDisk();

    public UserYandexDiskBuilder setLogin(String login) {
        user.setUsername(login);
        return this;
    }

    public UserYandexDiskBuilder setPassword(String password) {
        user.setUserPassword(password);
        return this;
    }

    public UserYandexDisk build() {
        return user;
    }
}

package webdriver.model;

public class UserYandexDisk {

    private String username;
    private String userPassword;

    public UserYandexDisk(String username, String password) {
        this.username = username;
        this.userPassword = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}

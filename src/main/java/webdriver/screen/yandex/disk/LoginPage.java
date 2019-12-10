package webdriver.screen.yandex.disk;

import org.openqa.selenium.By;
import webdriver.util.Log;
import webdriver.browser.Browser;
import webdriver.model.UserYandexDisk;

public class LoginPage {
    private static final String URL = "https://passport.yandex.ru/auth?from=cloud&origin=disk_landing2_signin_" +
            "ru&retpath=https%3A%2F%2Fdisk.yandex.ru%3Fsource%3Dlanding2_signin_ru&" +
            "backpath=https%3A%2F%2Fdisk.yandex.ru%3F";
    private static final By FIELD_FOR_LOGIN_LOCATOR = By.id("passp-field-login");
    private static final By BUTTON_LOGIN_LOCATOR = By.xpath("//*[@* = 'submit']");
    private static final By FIELD_FOR_PASSWORD_LOCATOR = By.id("passp-field-passwd");
    private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[@class='passp-form-field__error']");
    protected static Browser browser;

    public LoginPage() {
        if (browser == null) {
            browser = new Browser();
        }
    }

    public LoginPage open() {
        browser.getDriver().get(URL);
        Log.info("Login page opened");
        return this;
    }

    public LoginPage typeLogin(String login) {
        browser.typeText(FIELD_FOR_LOGIN_LOCATOR, login);
        Log.info(String.format("Typed: %s username", login));
        return this;
    }

    public LoginPage clickOnLogin() {
        browser.clickOnButton(BUTTON_LOGIN_LOCATOR);
        Log.info("Clicked on button login");
        return this;
    }

    public LoginPage typePassword(String password) {
        browser.typeText(FIELD_FOR_PASSWORD_LOCATOR, password);
        Log.info(String.format("Typed: %s password", password));
        return this;
    }

    public YandexDiskPage login(UserYandexDisk user) {
        typeLogin(user.getUsername())
                .clickOnLogin()
                .typePassword(user.getUserPassword())
                .clickOnLogin();
        Log.info("Login performed");
        return new YandexDiskPage();
    }

    public String getErrorTextMessage() {
        return browser.waitWebElement(ERROR_MESSAGE_LOCATOR).getText();
    }
}

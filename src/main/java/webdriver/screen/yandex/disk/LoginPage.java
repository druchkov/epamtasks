package webdriver.screen.yandex.disk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webdriver.browser.Browser;
import webdriver.model.UserYandexDisk;

public class LoginPage {
    private static final String URL = "https://passport.yandex.ru/auth?from=cloud&origin=disk_landing2_signin_" +
            "ru&retpath=https%3A%2F%2Fdisk.yandex.ru%3Fsource%3Dlanding2_signin_ru&" +
            "backpath=https%3A%2F%2Fdisk.yandex.ru%3F";
    private static final By FIELD_FOR_LOGIN_LOCATOR = By.id("passp-field-login");
    private static final By BUTTON_LOGIN_LOCATOR = By.xpath("//*[@* = 'submit']");
    private static final By FIELD_FOR_PASSWORD_LOCATOR = By.id("passp-field-passwd");
    private final Logger logger = LogManager.getRootLogger();
    Browser browser;

    public LoginPage(WebDriver driver) {
        if (browser == null) {
            browser = new Browser(driver);
        }
    }

    public LoginPage open() {
        browser.getDriver().get(URL);
        logger.info("Login page opened");
        return this;
    }

    public LoginPage typeLogin(String login) {
        browser.typeText(FIELD_FOR_LOGIN_LOCATOR, login);
        logger.info("Typed username");
        return this;
    }

    public LoginPage clickOnLogin() {
        browser.clickOnButton(BUTTON_LOGIN_LOCATOR);
        logger.info("clicked on button login");
        return this;
    }

    public LoginPage typePassword(String password) {
        browser.typeText(FIELD_FOR_PASSWORD_LOCATOR, password);
        logger.info("typed password");
        return this;
    }

    public YandexDiskPage login(UserYandexDisk user) {
        typeLogin(user.getUsername())
                .clickOnLogin()
                .typePassword(user.getUserPassword())
                .clickOnLogin();
        logger.info("Login performed");
        return new YandexDiskPage(browser.getDriver());
    }
}

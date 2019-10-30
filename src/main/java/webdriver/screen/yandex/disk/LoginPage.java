package webdriver.screen.yandex.disk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webdriver.browser.Browser;

public class LoginPage {
    private static final String URL = "https://passport.yandex.ru/auth?from=cloud&origin=disk_landing2_signin_" +
            "ru&retpath=https%3A%2F%2Fdisk.yandex.ru%3Fsource%3Dlanding2_signin_ru&" +
            "backpath=https%3A%2F%2Fdisk.yandex.ru%3F";
    private static final By FIELD_FOR_LOGIN_LOCATOR = By.id("passp-field-login");
    private static final By BUTTON_LOGIN_LOCATOR = By.xpath("//*[@* = 'submit']");
    private static final By FIELD_FOR_PASSWORD_LOCATOR = By.id("passp-field-passwd");
    Browser browser;

    public LoginPage(WebDriver driver) {
        if (browser == null) {
            browser = new Browser(driver);
        }
    }

    public LoginPage open() {
        browser.getDriver().get(URL);
        return this;
    }

    public LoginPage typeLogin(String login) {
        browser.typeText(FIELD_FOR_LOGIN_LOCATOR, login);
        return this;
    }

    public LoginPage clickOnLogin() {
        browser.clickOnButton(BUTTON_LOGIN_LOCATOR);
        return this;
    }

    public LoginPage typePassword(String password) {
        browser.typeText(FIELD_FOR_PASSWORD_LOCATOR, password);
        return this;
    }
}

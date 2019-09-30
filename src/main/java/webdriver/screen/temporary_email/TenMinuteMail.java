package webdriver.screen.temporary_email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.screen.cloud.Browser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TenMinuteMail extends Browser {
    private final String URL_PAGE = "https://10minutemail.com";
    private final By EMAIL_ADDRESS_LOCATOR = By.id("mailAddress");
    private final By FIRST_EMAIL_LOCATOR = By.id("ui-id-1");
    private final By COAST_VALUE_LOCATOR = By.xpath("//td[not(@colspan)]/h3");
//    private final int WAITING_TIME = 10;
//    private final int WAITING_EMAIL = 200;



    public TenMinuteMail(WebDriver driver) {
        super(driver);
    }

//    private WebElement waitElement(By by) {
//        return new WebDriverWait(driver, WAITING_TIME)
//                .until(ExpectedConditions.visibilityOfElementLocated(by));
//    }

    private WebElement waitElement(By by, int time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public TenMinuteMail openPage() {
        driver.get(URL_PAGE);
        return this;
    }

    public String getEmail() {
        return waitElement(EMAIL_ADDRESS_LOCATOR).getAttribute("value");
    }

    public String getCostPerMonth() {
        waitElement(FIRST_EMAIL_LOCATOR, WAITING_EMAIL).click();
        String costPerMonth = waitElement(COAST_VALUE_LOCATOR).getText();
        Pattern pattern = Pattern.compile("[0-9+,+\\.?]+");
        Matcher matcher = pattern.matcher(costPerMonth);
        matcher.find();
        return matcher.group();
    }
}

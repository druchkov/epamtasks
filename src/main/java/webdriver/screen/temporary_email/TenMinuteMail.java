package webdriver.screen.temporary_email;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    Logger logger = LogManager.getRootLogger();

    public TenMinuteMail(WebDriver driver) {
        super(driver);
    }

    private WebElement waitElement(By by, int time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public TenMinuteMail open() {
        driver.get(URL_PAGE);
        logger.info("page opened");
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
        logger.info("Cost per month received");
        return matcher.group();
    }
}

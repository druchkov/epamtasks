package webdriver.screen.cloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.screen.cloud.exception.ElementNotEnabledException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculetedResultPageObject extends GoogleCloudCalculatorPageObject {

    private final By VERTUAL_MACHINE_CLASS_LOCATOR =
            By.xpath("//md-card-content[@id = 'resultBlock']//div[contains(text(), 'VM')]");
    private final By INSTANCE_TYPE_LOCATOR =
            By.xpath("//md-card-content[@id = 'resultBlock']//div[contains(text(), 'Instance type')]");
    private final By REGION_LOCATOR =
            By.xpath("//md-card-content[@id = 'resultBlock']//div[contains(text(), 'Region')]");
    private final By TOTAL_SSD_LOCATOR =
            By.xpath("//md-card-content[@id = 'resultBlock']//div[contains(text(), 'local')]");
    private final By COST_PER_MONTH_LOCATOR =
            By.xpath("//md-card-content[@id = 'resultBlock']//div/b[contains(text(), 'Cost')]");
    private final By COMMITMENT_TERM_LOCATOR =
            By.xpath("//md-card-content[@id = 'resultBlock']//div[contains(text(), 'term')]");
    private final By BUTTON_EMAIL_ESTIMATE_LOCATOR = By.xpath("//button[@aria-label = 'Email Estimate']");
    private final By FIELD_EMAIL_LOCATOR = By.xpath("//input[@type ='email']");
    private final By BUTOON_SEND_EMAIL_LOCATOR = By.xpath("//button[@aria-label = 'Send Email']");


    public CalculetedResultPageObject(WebDriver driver) {
        super(driver);
    }

    private WebElement waitElement(By by) {
        return new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public CalculetedResultPageObject clickOnEmailEstimate() {
        waitElement(BUTTON_EMAIL_ESTIMATE_LOCATOR).click();
        return this;
    }

    public String getVMClass() {
        String[] splitText = waitElement(VERTUAL_MACHINE_CLASS_LOCATOR).getText().split(":");
        return splitText[1].trim();
    }

    public String getInstanceType() {
        String[] splitText = waitElement(INSTANCE_TYPE_LOCATOR).getText().split(":");
        return splitText[1].trim();
    }

    public String getRegion() {
        String[] splitText = waitElement(REGION_LOCATOR).getText().split(":");
        return splitText[1].trim();
    }

    public String getCommitmentTerm() {
        String[] splitText = waitElement(COMMITMENT_TERM_LOCATOR).getText().split(":");
        return splitText[1].trim();
    }

    public String getTotalLocalSSD() {
        String textTeg = waitElement(TOTAL_SSD_LOCATOR).getText();
        Pattern pattern = Pattern.compile("\\d+x{1}\\d+");
        Matcher matcher = pattern.matcher(textTeg);
        matcher.find();
        return matcher.group();
    }

    public String getCostPerMonth() {
        String textTeg = waitElement(COST_PER_MONTH_LOCATOR).getText();
        Pattern pattern = Pattern.compile("[0-9+,+\\.?]+");
        Matcher matcher = pattern.matcher(textTeg);
        matcher.find();
        return matcher.group();
    }

    public CalculetedResultPageObject typeEmail(String email) {
        waitElement(FIELD_EMAIL_LOCATOR).click();
        waitElement(FIELD_EMAIL_LOCATOR).sendKeys(email);
        return this;
    }

    public CalculetedResultPageObject sendEmail() throws ElementNotEnabledException {
        WebElement element = waitElement(BUTOON_SEND_EMAIL_LOCATOR);
        if (element.isEnabled()) {
            element.click();
        } else {
            throw new ElementNotEnabledException();
        }
        return this;
    }
}

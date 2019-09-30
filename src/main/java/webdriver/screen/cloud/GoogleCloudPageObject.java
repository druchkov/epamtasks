package webdriver.screen.cloud;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPageObject {
    private static String GOOGLE_CLOUD_URL = "https://cloud.google.com/";
    private static By SEARCH_INPUT_LOCATOR = By.name("q");
    private static By BUTTON_SHOW_RESULT_LOCATOR =  By.className("button button-white devsite-suggest-all-results");
    private final int WAITING_TIME = 10;

    WebDriver driver;

    public GoogleCloudPageObject(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().maximize();
    }

    private WebElement waitElement(By by) {
        return new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public GoogleCloudPageObject openPage() {
        driver.get(GOOGLE_CLOUD_URL);
        return this;
    }

    public GoogleCloudPageObject clickOnLoupe() {
        waitElement(SEARCH_INPUT_LOCATOR).click();
        return this;
    }

    public ShowResultObject inputSearchQueryAndSumbit(String query) {
        waitElement(SEARCH_INPUT_LOCATOR).sendKeys(query + Keys.ENTER);
        return new ShowResultObject(driver);
    }

    public ShowResultObject clickOnShowResult() {
        waitElement(BUTTON_SHOW_RESULT_LOCATOR).click();
        return new ShowResultObject(driver);
    }
}

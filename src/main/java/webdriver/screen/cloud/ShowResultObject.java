package webdriver.screen.cloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShowResultObject {
    private final By FIRST_LINK_LOCATOR =
            By.xpath("//div[@class = 'gs-title']/a[@data-ctorig = 'https://cloud.google.com/products/calculator/']");
    private final int WAITING_TIME = 10;

    WebDriver driver;

    public ShowResultObject(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
    }

    private WebElement waitElement(By by) {
        return new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public GoogleCloudCalculatorPageObject clickOnFirstLink() {
        waitElement(FIRST_LINK_LOCATOR).click();
        return new GoogleCloudCalculatorPageObject(driver);
    }
}

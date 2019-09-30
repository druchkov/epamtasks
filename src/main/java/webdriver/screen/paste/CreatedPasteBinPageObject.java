package webdriver.screen.paste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreatedPasteBinPageObject {
    private final By LANGUAGE_LOCATOR  = By.xpath("//span[@class= 'h_640']/a");
    private final By ROWS_CODE_LOCATOR = By.xpath("//li[@class = 'li1']");
    private final int WAITING_TIME = 10;
    WebDriver driver;

    public CreatedPasteBinPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitlePage() {
        return driver.getTitle();
    }

    private WebElement waitElement(By by) {
        return new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private List<WebElement> waitAllElements(By by) {
        return new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public String getLanguageHighlight() {
        return waitElement(LANGUAGE_LOCATOR).getText();
    }

    public String getCode() {
        List<WebElement> elements = waitAllElements(ROWS_CODE_LOCATOR);
        String code = "";
        for(WebElement element: elements) {
            code += element.getText() + "\n";
        }
        return code.substring(0, code.length() - 1);
    }
}

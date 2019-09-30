package webdriver.screen.paste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.screen.type.TypePasteExpiration;
import webdriver.screen.type.TypeSyntax;

public class PasteBinPageObject {
    private final String PASTE_BIN_URL = "https://pastebin.com/";
    private final By NEW_PASTA_TEXT_AREA_LOCATOR = By.id("paste_code");
    private final By SYNTAX_HIGHLIGHTING_LOCATOR = By.name("paste_format");
    private final By PASTE_EXPIRATION_LOCATOR = By.name("paste_expire_date");
    private final By PASTE_NAME_LOCATOR = By.name("paste_name");
    private final By BUTTON_CREATE_EW_PASTE_LOCATOR = By.id("submit");
    private final int WAITING_TIME = 10;

    WebDriver driver;


    public PasteBinPageObject(WebDriver webDriver) {
        this.driver = webDriver;
        this.driver.manage().window().maximize();
    }

    private WebElement waitElement(By by) {
        return new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private Select findSelect (By by) {
        return new Select(waitElement(by));
    }

    public PasteBinPageObject openPage() {
        driver.get(PASTE_BIN_URL);
        return this;
    }

    public PasteBinPageObject inputTextInPaste(String text) {
        waitElement(NEW_PASTA_TEXT_AREA_LOCATOR).sendKeys(text);
        return this;
    }

    public PasteBinPageObject selectSyntaxHighlighting(TypeSyntax typeSyntax) {
        findSelect(SYNTAX_HIGHLIGHTING_LOCATOR).selectByVisibleText(typeSyntax.getNameLang());
        return this;
    }

    public PasteBinPageObject selectPasteExpiration(TypePasteExpiration expiration) {
        findSelect(PASTE_EXPIRATION_LOCATOR).selectByIndex(expiration.ordinal());
        return this;
    }

    public PasteBinPageObject typePasteName(String name) {
        waitElement(PASTE_NAME_LOCATOR).sendKeys(name);
        return this;
    }

    public CreatedPasteBinPageObject clickOnCreateNewPaste() {
        waitElement(BUTTON_CREATE_EW_PASTE_LOCATOR).click();
        return new CreatedPasteBinPageObject(driver);
    }
}


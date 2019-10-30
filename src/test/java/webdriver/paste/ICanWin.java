package webdriver.paste;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.browser.BrowserFactory;
import webdriver.browser.TypeBrowser;
import webdriver.screen.type.TypePasteExpiration;
import webdriver.screen.paste.CreatedPasteBinPageObject;
import webdriver.screen.paste.PasteBinPageObject;

public class ICanWin {
    String text = "Hello from WebDriver";
    TypePasteExpiration expiration = TypePasteExpiration.TEN_MINUTES;
    String title = "helloweb";

    WebDriver driver = BrowserFactory.getBrowser(TypeBrowser.OPERA);
    PasteBinPageObject pasteBin = new PasteBinPageObject(driver);


    @BeforeTest
    public void openPage() {
        pasteBin.openPage();
    }

    @AfterTest
    public void quitOfDriver() {
        driver.quit();
    }

    @Test
    public void createNewPaste() {
        pasteBin.inputTextInPaste(text)
                .selectPasteExpiration(expiration)
                .typePasteName(title)
                .clickOnCreateNewPaste();
        Assert.assertEquals(
                new CreatedPasteBinPageObject(driver).getTitlePage(), title + " - Pastebin.com" , "Should be equals");
    }


}

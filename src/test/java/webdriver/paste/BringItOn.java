package webdriver.paste;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.screen.type.TypePasteExpiration;
import webdriver.screen.type.TypeSyntax;
import webdriver.screen.paste.CreatedPasteBinPageObject;
import webdriver.screen.paste.PasteBinPageObject;

public class BringItOn {
    String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    TypeSyntax syntax = TypeSyntax.BASH;
    TypePasteExpiration expiration = TypePasteExpiration.TEN_MINUTES;
    String title = "how to gain dominance among developers";

    WebDriver driver = new ChromeDriver();
    CreatedPasteBinPageObject createdPaste = new CreatedPasteBinPageObject(driver);

    @BeforeClass
    public void createPasteBin() {
        PasteBinPageObject pasteBin = new PasteBinPageObject(driver);
        pasteBin.openPage()
                .inputTextInPaste(code)
                .selectSyntaxHighlighting(syntax)
                .selectPasteExpiration(expiration)
                .typePasteName(title)
                .clickOnCreateNewPaste();
    }

    @AfterClass
    public void quitOfDriver() {
        driver.quit();
    }

    @Test
    public void syntaxHighLightTest() {
        Assert.assertEquals(createdPaste.getLanguageHighlight(), syntax.getNameLang(), "should be equals");
    }

    @Test
    public void containsCodeTest() {
        Assert.assertEquals(createdPaste.getCode(), code, "should be equals");
    }

    @Test
    public void titlePageBrowserTest() {
        Assert.assertEquals(createdPaste.getTitlePage(),"[" + syntax.getNameLang() + "] " + title + " - Pastebin.com" );
    }
}

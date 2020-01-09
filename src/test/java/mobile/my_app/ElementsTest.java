package mobile.my_app;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ElementsTest extends SourceTest {

    @Test(description = "Check name button")
    public void textButtonTest() {
        String nameElement = page.getTextButton();
        Assert.assertEquals(nameElement, "Рассчитать", "Name button should be 'Рассчитать'");
    }

    @Test(description = "Check hint edit text")
    public void hintEditTextTest() {
        String nameElement = page.getTextEdit();
        Assert.assertEquals(nameElement, "Введите выражение", "Hint should be 'Введите выражение'");
    }

    @Test(description = "Check text response")
    public void checkResponseTest() {
        String nameElement = page.getTextResponse();
        Assert.assertEquals(nameElement, "Ответ", "Response message should be 'Ответ'");
    }

    @Test(description = "Check button state")
    public void checkButtonState() {
        Assert.assertTrue(page.isCalculateButtonEnabled(), "Button doesn't enabled ");
    }
}

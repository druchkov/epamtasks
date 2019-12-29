package mobile.my_app;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class ElementsTest extends SourceTest{

    @Test(description = "Check name button")
    public void textButtonTest() {
        try {
            String nameElement = page.getTextButton();
            Assert.assertEquals(nameElement, "Рассчитать", "Name button should be 'Рассчитать'");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Check hint edit text")
    public void hintEditTextTest() {
        try {
            String nameElement = page.getTextEdit();
            Assert.assertEquals(nameElement, "Введите выражение", "Name button should be 'Введите выражение'");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Check text response")
    public void checkResponseTest() {
        try {
            String nameElement = page.getTextResponse();
            Assert.assertEquals(nameElement, "Ответ", "Name button should be 'Ответ'");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Check button state")
    public void checkButtonState() {
        try {
            Assert.assertTrue(page.isCalculateButtonEnabled(), "Button doesn't enabled ");
        } catch (MalformedURLException exp) {
            exp.printStackTrace();
        }
    }
}

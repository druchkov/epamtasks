package mobile.my_app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class CalculateTest extends SourceTest {

    @Test(description = "Check correct calculate", dataProvider = "calculate")
    public void calculate(String expression, String response) throws MalformedURLException {
        String message = page.typeExpression(expression)
                .clickOnCalculate()
                .getTextResponse();
        Assert.assertEquals(message, response, "Message should be '" + response + "'");
    }

    @DataProvider(name = "calculate")
    public Object[][] calculateData() {
        return new Object[][]{
                {"()", "Выражение верно"},
                {"{}]", "Выражение не верно"},
                {"", "Выражение пустое"}
        };
    }
}

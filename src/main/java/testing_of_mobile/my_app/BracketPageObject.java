package testing_of_mobile.my_app;

import org.openqa.selenium.By;
import testing_of_mobile.FunctionForMobile;


public class BracketPageObject {

    private static String ID = "by.gomel.bracket:id/";
    private static By BUTTON_CALCULATE_LOCATOR = By.id(ID + "button");
    private static By RESPONSE_LOCATOR = By.id(ID + "response");
    private static By EDIT_TEXT_LOCATOR = By.id(ID + "input_field");
    private FunctionForMobile browser = new FunctionForMobile();

    public BracketPageObject clickOnCalculate() {
        browser.clickOnButton(BUTTON_CALCULATE_LOCATOR);
        return this;
    }

    public boolean isCalculateButtonEnabled() {
        return browser.isButtonEnabled(BUTTON_CALCULATE_LOCATOR);
    }

    public BracketPageObject typeExpression(String expression) {
        browser.typeText(EDIT_TEXT_LOCATOR, expression);
        return this;
    }

    public String getTextButton() {
        return browser.getTextElement(BUTTON_CALCULATE_LOCATOR);
    }

    public String getTextEdit() {
        return browser.getTextElement(EDIT_TEXT_LOCATOR);
    }

    public String getTextResponse() {
        return browser.getTextElement(RESPONSE_LOCATOR);
    }
}

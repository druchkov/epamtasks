package webdriver.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import webdriver.factory.UserYandexDiskFactory;
import webdriver.screen.yandex.disk.LoginPage;

public class LoginPageSteps {

    @Given("^(The )?[Uu]ser opens? yandex disk page$")
    public void userOpenedYandexDiskPage() {
        new LoginPage().open();
    }

    @When("^(The )?[Uu]ser login with correct credentials$")
    public void loginWithCorrectCredentials() {
        new LoginPage().login(UserYandexDiskFactory.withCredentialsFromProperty());
    }

    @And("^(The )?[Uu]ser clicks button login$")
    public void clickEnter() {
        new LoginPage().clickOnLogin();
    }

    @Then("^(The )?[Uu]ser sees error message with text ([\\w]+)$")
    public void error(String text) {
        String errorMessage = new LoginPage().getTextMessage();
        Assert.assertEquals(text, errorMessage, "Messages don't equals");
    }

    @When("^(The )?[Uu]ser types ([\\w]+) in filed for login name$")
    public void typeLogin(String login) {
        new LoginPage().typeLogin(login);
    }
}

package webdriver.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import webdriver.factory.UserYandexDiskFactory;
import webdriver.screen.yandex.disk.LoginPage;

import java.util.Map;

public class LoginPageSteps {

    @Given("^(The )?[Uu]ser (?:opens?|navigetes? to) (?:[the ]?[Hh]ome page|[the ]?[Yy]andex disk page)$")
    public void userOpenedYandexDiskPage() {
        new LoginPage().open();
    }

    @When("^(The )?[Uu]ser (?:logins?|enters?) with correct credentials$")
    public void loginWithCorrectCredentials() {
        new LoginPage().login(UserYandexDiskFactory.withCredentialsFromProperty());
    }

    @And("^(The )?[Uu]ser clicks button login$")
    public void clickEnter() {
        new LoginPage().clickOnLogin();
    }

    @Then("^(The )?[Uu]ser sees error message with text ([\\w]+)$")
    public void userSeesErrorMessage(String text) {
        String errorMessage = new LoginPage().getErrorTextMessage();
        Assert.assertEquals(text, errorMessage, "Message does't equals");
    }

    @When("^(The )?[Uu]ser types ([\\w]+) (in filed for)? login name$")
    public void typeLogin(String login) {
        new LoginPage().typeLogin(login);
    }

    @When("^(The )?[Uu]ser logins? with parameters?:$")
    public void userLoginWithParameters(DataTable userWithParameters) {
        Map<String, String> user = userWithParameters.asMap(String.class, String.class);
        new LoginPage()
                .login(UserYandexDiskFactory
                        .withAnyCredentials(user.get("loginName"), user.get("password")));
    }
}

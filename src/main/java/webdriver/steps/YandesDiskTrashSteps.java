package webdriver.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import webdriver.screen.yandex.disk.TrashPage;
import webdriver.service.disk.YandexDiskTrashServices;

public class YandesDiskTrashSteps {

    @Given("^(The )?[Uu]ser clears trash$")
    public void clearTrash() {
        YandexDiskTrashServices.clearTrash();
    }

    @Then("Trash is empty")
    public void isEmpty() {
        boolean trash = new TrashPage().isTrashEmpty();
        Assert.assertTrue(trash, "Trash is not empty");
    }
}

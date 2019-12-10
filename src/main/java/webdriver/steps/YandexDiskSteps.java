package webdriver.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import webdriver.screen.yandex.disk.YandexDiskPage;
import webdriver.service.disk.YandexDiskServices;

public class YandexDiskSteps {

    @Given("^(The )?[Uu]ser creates new folder \"(\\w+)\"$")
    public void createNewFolder(String name) {
        YandexDiskServices.createNewFolder(name);
    }

    @Given("^(The )?[Uu]ser deletes file with name \"(\\w+)\"$")
    public void removeFile(String name) {
        new YandexDiskPage().moveFileInTrash(name);
    }

    @Given("^(The )?[Uu]ser clicks? on trash (link)?$")
    public void clickOnTrash() {
        new YandexDiskPage().clickOnTrashLink();
    }

    @Then("^(The )?[Uu]ser riches? (?:[Yy]andex disk|[Mm]ain page)$")
    public void yandexDiskOpen() {
        boolean result = new YandexDiskPage().isPageOpened();
        Assert.assertTrue(result, "Page wasn't open");
    }
}
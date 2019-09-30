package webdriver.cloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.screen.cloud.CalculetedResultPageObject;
import webdriver.screen.cloud.service.CalculateService;
import webdriver.screen.cloud.service.FactoryCalculator;

public class HurtMePlenty {
    WebDriver driver = new ChromeDriver();
    CalculetedResultPageObject pageObject = new CalculetedResultPageObject(driver);
    String costPerMonth = "1,187.77";

    @BeforeClass
    public void calculate() {
        new CalculateService().calculate(driver, FactoryCalculator.calculateWitParametersFromTask());
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void vmClassTest() {
        Assert.assertEquals(pageObject.getVMClass(), "regular");
    }

    @Test
    public void instanceTypeTest() {
        Assert.assertEquals(pageObject.getInstanceType(), "n1-standard-8");
    }

    @Test
    public void regionTest() {
        Assert.assertEquals(pageObject.getRegion(), "Frankfurt");
    }

    @Test
    public void localSSD() {
        Assert.assertEquals(pageObject.getTotalLocalSSD(), "2x375");
    }

    @Test
    public void costPerMonthTest() {
        Assert.assertEquals(pageObject.getCostPerMonth(), costPerMonth);
    }

    @Test
    public void commitmentTermTest() {
        Assert.assertEquals(pageObject.getCommitmentTerm(), "1 Year");
    }


}

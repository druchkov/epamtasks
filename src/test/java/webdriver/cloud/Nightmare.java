package webdriver.cloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.screen.cloud.CalculetedResultPageObject;
import webdriver.screen.cloud.exception.ElementNotEnabledException;
import webdriver.screen.cloud.service.CalculateService;
import webdriver.screen.cloud.service.FactoryCalculator;
import webdriver.screen.temporary_email.TenMinuteMail;

public class Nightmare {

    WebDriver driver = new ChromeDriver();
    CalculetedResultPageObject pageObject = new CalculetedResultPageObject(driver);
    TenMinuteMail mail = new TenMinuteMail(driver);
    String costPerMonth = "1,187.77";

    @BeforeTest
    public void setUp() {
        new CalculateService().calculate(driver, FactoryCalculator.calculateWitParametersFromTask());
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void sss() {
        mail.createNewWindow().switchBetweenTwoTabs();
        mail.openPage();
        String email = mail.getEmail();
        mail.switchBetweenTwoTabs();
        driver.switchTo().frame(0);
        pageObject.clickOnEmailEstimate();
        try {
            pageObject.typeEmail(email).sendEmail();
        } catch (ElementNotEnabledException e) {
            e.printStackTrace();
        }
        mail.switchBetweenTwoTabs();
        String costPerMonthWithEmail = mail.getCostPerMonth();
        Assert.assertEquals(costPerMonthWithEmail, costPerMonth);
    }

}

package webdriver.cloud;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import webdriver.browser.Browser;
import webdriver.driver.DriverManager;
import webdriver.screen.cloud.CalculetedResultPageObject;
import webdriver.screen.cloud.exception.ElementNotEnabledException;
import webdriver.service.CalculateService;
import webdriver.screen.cloud.service.FactoryCalculator;
import webdriver.screen.temporary_email.TenMinuteMail;
import webdriver.util.TestListener;

@Listeners({TestListener.class})
public class Nightmare {

    WebDriver driver = DriverManager.getDriver();
    Browser browser = new Browser();
    CalculetedResultPageObject pageObject = new CalculetedResultPageObject(driver);
    TenMinuteMail mail = new TenMinuteMail(driver);
    String costPerMonth = "1,082.77";

    @BeforeTest
    public void setUp() {
        new CalculateService().calculate(driver, FactoryCalculator.calculateWitParametersFromTask());
    }

    @AfterTest
    public void quitDriver() {
        DriverManager.quiteDriver();
    }

    @Test
    public void sss() {
        browser.createNewWindow();
        browser.switchBetweenTwoTabs();
        mail.open();
        String email = mail.getEmail();
        browser.switchBetweenTwoTabs();
        driver.switchTo().frame(0);
        pageObject.clickOnEmailEstimate();
        try {
            pageObject.typeEmail(email).sendEmail();
        } catch (ElementNotEnabledException e) {
            e.printStackTrace();
        }
        browser.switchBetweenTwoTabs();
        String costPerMonthWithEmail = mail.getCostPerMonth();
        Assert.assertEquals(costPerMonthWithEmail, costPerMonth);
    }

}

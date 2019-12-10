package webdriver.steps;

import cucumber.api.java.After;
import webdriver.driver.DriverManager;

public class ScenarioHooks {
    @After
    public void killDriver() {
        DriverManager.quiteDriver();
    }
}

package webdriver.screen.cloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.screen.cloud.type.*;

import java.util.List;

public class GoogleCloudCalculatorPageObject {
    private final By I_FRAME_CALCULATOR = By.id("idIFrame");
    private final By COMPUTE_ENGINE_LOCATOR = By.className("hexagon-in2");
    private final By NUMBER_OF_INSTANCES_LOCATOR = By.id("input_53");
    private final By OPERATING_SYSTEM_LOCATOR = By.id("select_value_label_46");
    private final By MACHINE_CLASS_LOCATOR = By.xpath("//md-select[@placeholder = 'VM Class']");
    private final By MACHINE_TYPE_LOCATOR = By.xpath("//md-select[@placeholder = 'Instance type']");
    private final By ADD_GPU_LOCATOR =
            By.xpath("//md-checkbox[@aria-label = 'Add GPUs']/div[@class= 'md-container md-ink-ripple']");
    private final By NUMBER_GPU_LOCATOR = By.xpath("//md-select[@placeholder = 'Number of GPUs']");
    private final By GPU_TYPE_LOCATOR = By.xpath("//md-select[@placeholder = 'GPU type']");
    private final By LOCAL_SSD_LOCATOR = By.xpath("//md-select[@placeholder = 'Local SSD']");
    private final By DATA_CENTER_LOCATION_LOCATOR = By.xpath("//md-select[@placeholder = 'Datacenter location']");
    private final By COMMITTED_USAGE_LOCATOR = By.id("select_value_label_52");
    private final By BUTTON_ADD_TO_ESTIMATE_LOCATOR =
            By.xpath("//form[@name='ComputeEngineForm']//button[@aria-label = 'Add to Estimate']");
    protected final int WAITING_TIME = 10;

    protected WebDriver driver;

    public GoogleCloudCalculatorPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver switchToFrame() {
        return new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(I_FRAME_CALCULATOR));
    }

    private WebDriver switchToDefault() {
        return driver.switchTo().defaultContent();
    }

    private WebElement waitElement(By by) {
        return new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private List<WebElement> waitAllElements(By by) {
        return new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public GoogleCloudCalculatorPageObject typeComputeEngine() {
        driver.switchTo().frame(0);
        waitElement(COMPUTE_ENGINE_LOCATOR).click();
        return this;
    }

    public GoogleCloudCalculatorPageObject inputNumberOfInstances(int count) {
        waitElement(NUMBER_OF_INSTANCES_LOCATOR).click();
        waitElement(NUMBER_OF_INSTANCES_LOCATOR).sendKeys(Integer.toString(count));
        return this;
    }

    public GoogleCloudCalculatorPageObject choiseOperatingSystem(TypeOperatingSystem operatingSystem) {
        waitElement(OPERATING_SYSTEM_LOCATOR).click();
        waitElement(By.xpath(operatingSystem.getPath())).click();
        return this;
    }

    public GoogleCloudCalculatorPageObject choiceMachineClass(TypeMachineClass machineClass) {
        waitElement(MACHINE_CLASS_LOCATOR).click();
        String locator = String
                .format("//md-select-menu[@style]//div[contains(text(), '%s')]", machineClass.getMachineClass());
        waitElement(By.xpath(locator)).click();
        return this;
    }

    public GoogleCloudCalculatorPageObject choiceMachineTypeStandart8() {
        waitElement(MACHINE_TYPE_LOCATOR).click();
        waitElement(By.xpath("//div[contains(text(), 'n1-standard-8')]")).click();
        return this;
    }

    public GoogleCloudCalculatorPageObject checkAddGPU() {
        waitElement(ADD_GPU_LOCATOR).click();
        return this;
    }

    public GoogleCloudCalculatorPageObject choiceCountGPU(int count) {
        waitElement(NUMBER_GPU_LOCATOR).click();
        List<WebElement> elements =
                waitAllElements(By.xpath("//div[@id = 'select_container_349']//div[@class = 'md-text ng-binding']"));
        if (count == 0) {
            elements.get(0).click();
        } else if (count == 1) {
            elements.get(1).click();
        } else if (count == 2) {
            elements.get(2).click();
        } else if (count == 4) {
            elements.get(3).click();
        } else if (count == 8) {
            elements.get(4).click();
        } else {
            throw new IllegalArgumentException("nonexistent amount GPUs");
        }
        return this;
    }

    public GoogleCloudCalculatorPageObject choiceTypeGPU(TypeGPU gpu) {
        waitElement(GPU_TYPE_LOCATOR).click();
        String locator = String.format("//md-option[@value = '%s']/div", gpu.getName());
        waitElement(By.xpath(locator)).click();
        return this;
    }

    public GoogleCloudCalculatorPageObject choiceLocalSsd(int countLocalSSD) {
        waitElement(LOCAL_SSD_LOCATOR).click();
        if (countLocalSSD > 8 || countLocalSSD < 1) {
            throw new IllegalArgumentException("count local ssd should be between 1 and 8");
        }
        String locator = String.format("//md-option[@value]/div[contains(text(),'%dx375 GB')]", countLocalSSD);
        waitElement(By.xpath(locator)).click();
        return this;
    }

    public GoogleCloudCalculatorPageObject choiceDataCenterLocation(TypeDataCenterLocation location) {
        waitElement(DATA_CENTER_LOCATION_LOCATOR).click();
        waitElement(By.id(location.getIdLocator())).click();
        return this;
    }

    public GoogleCloudCalculatorPageObject choiceDurationUsage(TypeDurationUsage duration) {
        waitElement(COMMITTED_USAGE_LOCATOR).click();
        String locator = String.format("//md-select-menu[@style]//div[text() ='%s']", duration.getDuration());
        waitElement(By.xpath(locator)).click();
        return this;
    }

    public CalculetedResultPageObject clickOnAddToEstimate() {
        waitElement(BUTTON_ADD_TO_ESTIMATE_LOCATOR).click();
        return new CalculetedResultPageObject(driver);
    }
}

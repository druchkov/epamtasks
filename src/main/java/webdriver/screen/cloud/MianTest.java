package webdriver.screen.cloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webdriver.screen.cloud.type.*;

public class MianTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        GoogleCloudPageObject cloudPage = new GoogleCloudPageObject(driver);
        cloudPage.openPage()
                .clickOnLoupe()
                .inputSearchQueryAndSumbit("Google Cloud Platform Pricing Calculator")
                .clickOnFirstLink()
                .typeComputeEngine()
                .inputNumberOfInstances(4)
                .choiseOperatingSystem(TypeOperatingSystem.FREE)
                .choiceMachineClass(TypeMachineClass.Regular)
                .choiceMachineTypeStandart8()
                .checkAddGPU()
                .choiceCountGPU(1)
                .choiceTypeGPU(TypeGPU.V100)
                .choiceLocalSsd(2)
                .choiceDataCenterLocation(TypeDataCenterLocation.FRANKFURT)
                .choiceDurationUsage(TypeDurationUsage.ONE_YEAR)
                .clickOnAddToEstimate();
    }
}

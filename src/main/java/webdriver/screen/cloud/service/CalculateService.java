package webdriver.screen.cloud.service;

import org.openqa.selenium.WebDriver;
import webdriver.screen.cloud.GoogleCloudPageObject;

public class CalculateService {

    public void calculate(WebDriver driver, CloudParameters cloudParameters) {
        new GoogleCloudPageObject(driver)
                .openPage()
                .clickOnLoupe()
                .inputSearchQueryAndSumbit(cloudParameters.getSearchQuery())
                .clickOnFirstLink()
                .typeComputeEngine()
                .inputNumberOfInstances(cloudParameters.getNumberOfInstances())
                .choiseOperatingSystem(cloudParameters.getOperatingSystem())
                .choiceMachineClass(cloudParameters.getMachineClass())
                .choiceMachineTypeStandart8()
                .checkAddGPU()
                .choiceCountGPU(cloudParameters.getCountGPU())
                .choiceTypeGPU(cloudParameters.getGPU())
                .choiceLocalSsd(cloudParameters.getLocalSsd())
                .choiceDataCenterLocation(cloudParameters.getDataCenterLocation())
                .choiceDurationUsage(cloudParameters.getDurationUsage())
                .clickOnAddToEstimate();
    }
}

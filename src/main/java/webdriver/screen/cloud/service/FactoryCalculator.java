package webdriver.screen.cloud.service;

import webdriver.screen.cloud.type.*;

public class FactoryCalculator {

    public static CloudParameters calculateWitParametersFromTask () {
        CloudParameters cloudParameters = new CloudParameters();
        cloudParameters.setSearchQuery("Google Cloud Platform Pricing Calculator");
        cloudParameters.setNumberOfInstances(4);
        cloudParameters.setOperatingSystem(TypeOperatingSystem.FREE);
        cloudParameters.setMachineClass(TypeMachineClass.Regular);
        cloudParameters.setCountGPU(1);
        cloudParameters.setGPU(TypeGPU.V100);
        cloudParameters.setLocalSsd(2);
        cloudParameters.setDataCenterLocation(TypeDataCenterLocation.FRANKFURT);
        cloudParameters.setDurationUsage(TypeDurationUsage.ONE_YEAR);
        return cloudParameters;
    }
}

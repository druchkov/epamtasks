package webdriver.screen.cloud.service;

import webdriver.screen.cloud.type.*;

public class CloudParameters {
    private String searchQuery;
    private int numberOfInstances;
    private TypeOperatingSystem operatingSystem;
    private TypeMachineClass machineClass;
    private int countGPU;
    private TypeGPU GPU;
    private int localSsd;
    private TypeDataCenterLocation dataCenterLocation;
    private TypeDurationUsage durationUsage;

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public TypeOperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(TypeOperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public TypeMachineClass getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(TypeMachineClass machineClass) {
        this.machineClass = machineClass;
    }

    public TypeGPU getGPU() {
        return GPU;
    }

    public void setGPU(TypeGPU GPU) {
        this.GPU = GPU;
    }

    public int getLocalSsd() {
        return localSsd;
    }

    public void setLocalSsd(int localSsd) {
        this.localSsd = localSsd;
    }

    public TypeDataCenterLocation getDataCenterLocation() {
        return dataCenterLocation;
    }

    public void setDataCenterLocation(TypeDataCenterLocation dataCenterLocation) {
        this.dataCenterLocation = dataCenterLocation;
    }

    public TypeDurationUsage getDurationUsage() {
        return durationUsage;
    }

    public void setDurationUsage(TypeDurationUsage durationUsage) {
        this.durationUsage = durationUsage;
    }

    public int getCountGPU() {
        return countGPU;
    }

    public void setCountGPU(int countGPU) {
        this.countGPU = countGPU;
    }
}

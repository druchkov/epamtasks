package webdriver.screen.cloud.type;

public enum TypeGPU {
    K80("K80"), P100("P100"), P4("P4"), V100("V100"), T4("T4");

    String name;

    TypeGPU(String name) {
        this.name = name;
    }

    public String getName() {
        return "NVIDIA_TESLA_" + name;
    }
}

package webdriver.screen.cloud.type;

public enum TypeMachineClass {
    Regular("Regular"), Preemptible("Preemptible");

    private String name;

    TypeMachineClass(String name) {
        this.name = name;
    }

    public String getMachineClass() {
        return name;
    }
}

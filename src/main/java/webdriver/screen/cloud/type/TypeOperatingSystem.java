package webdriver.screen.cloud.type;

public enum TypeOperatingSystem {
    FREE("//md-option/div[contains(text(), 'Debian, CentOS')]"),
    SLES_FOR_SAP("//md-option/div[contains(text(), 'SLES for SAP')]"),
    SLES("//md-option/div[text() = 'Paid: SLES']");

    String path;

    TypeOperatingSystem (String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

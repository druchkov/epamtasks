package webdriver.browser;

public enum TypeBrowser {
    CHROME("chrome"), OPERA("opera"), FIREFOX("firefox");

    private String nameBrowser;

    TypeBrowser(String nameBrowser) {
        this.nameBrowser = nameBrowser;
    }

    public String getNameBrowser() {
        return  nameBrowser;
    }
}

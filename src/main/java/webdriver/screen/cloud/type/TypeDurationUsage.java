package webdriver.screen.cloud.type;

public enum TypeDurationUsage {
    ONE_YEAR("1 Year"),
    THREE_YEARS("3 Years");

    String duration;

    TypeDurationUsage(String duration) {
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }
}

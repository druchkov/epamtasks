package classes.address;

public enum Towns {
    GOMEL("Гомель"), BREST("Брест"), RECHICA("Речица"), MOZIR("Мозырь"), MOGILEV("Могилев");

    private String town;

    Towns(String town) {
        this.town = town;
    }

    public String getTown() {
        return town;
    }
}

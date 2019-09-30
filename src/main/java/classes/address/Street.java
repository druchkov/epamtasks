package classes.address;

public enum Street {
    ALMAZNAYA("Алмазная"),
    BABUSHKINA("Бабушкина"),
    BANNAYA("Банная"),
    VERBNAYA("Вербная"),
    VOLNAYA("Волная"),
    GAGARINA("Гагарина"),
    DVORNIKOVA("Дворникова"),
    KALININA("Калинина"),
    KIROVA("Кирова");

    private String street;

    Street(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }
}

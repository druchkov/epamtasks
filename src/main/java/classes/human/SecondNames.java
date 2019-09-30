package classes.human;

public enum SecondNames {
    SMIRNOV("Смиронов"),
    IVANOV("Иванов"),
    KYZNECOV("Кузнецов"),
    POPOV("Попов"),
    SOKOLOV("Соколов"),
    LEBEDEV("Лебевев"),
    KOZLOV("Козлов"),
    NOVIKOV("Новиков"),
    MOROZOV("Морозов"),
    PETROV("Петров"),
    VOLKOV("Волков"),
    ZAYCEV("Зайцев"),
    PAVLOV("Павлов"),
    SEMENOV("Семенов"),
    VOINOV("Воинов"),
    BOGDANOVA("Богданов");

    private String secondName;

    SecondNames(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondName() {
        return secondName;
    }
}

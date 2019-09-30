package classes.human;

public enum ManNames {
    ARTEM("Артем"),
    DENIS("Денис"),
    MAXIM("Максим"),
    IVAN("Иван"),
    ROMAN("Роман"),
    ALEXANDR("Александр"),
    DANIIL("Даниил");
    private String name;

    ManNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

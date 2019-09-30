package classes.human;

public enum WomanNames {
    SOFIA("София"),
    MARIA("Мария"),
    POLINA("Полина"),
    ANNA("Анна"),
    DARIA("Дарья"),
    KSENIA("Ксения"),
    ALISA("Алиса");

    private String name;

    WomanNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}




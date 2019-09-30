package webdriver.screen.type;

public enum TypeSyntax {
    NONE("None"), BASH("Bash"), C("C"), C_SHARP("C#"), C_PLUS_PLUS("C++"), CSS("CSS"), HTML("HTML"), JAVA("JAVA");

    private String name;

    TypeSyntax(String name) {
        this.name = name;
    }

    public String getNameLang() {
        return name;
    }
}

package classes.student;

public enum Faculty {
    BIOLOGY("Биологии"),
    HISTORY("Истории"),
    MATH("Математики и технологий программирования"),
    PSYCHOLOGY("Психологии и педагогики"),
    PHYSICS("Физики и информационных техналогий"),
    LAW("Юридический"),
    ECONOMICS("Экономический");

    private String department;

    Faculty(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department.toLowerCase();
    }
}

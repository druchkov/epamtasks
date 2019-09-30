package classes.human;

public class Human implements Comparable<Human> {
    private String name;
    private String secondName;
    private String parentName;

    public Human() {
    }

    public Human(String name, String secondName, String parentName) {
        this.name = name;
        this.secondName = secondName;
        this.parentName = parentName;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return getSecondName() + " "
                + getName() + " "
                + getParentName() + " ";
    }

    @Override
    public int compareTo(Human o) {
        if (this.secondName.compareTo(o.getSecondName()) > 0) {
            return +1;
        }
        if (this.secondName.compareTo(o.getSecondName()) < 0) {
            return -1;
        }
        if (this.name.compareTo(o.getName()) > 0) {
            return +1;
        }
        if (this.name.compareTo(o.getName()) < 0) {
            return -1;
        }
        if (this.parentName.compareTo(o.getParentName()) > 0) {
            return +1;
        }
        if (this.parentName.compareTo(o.getParentName()) < 0) {
            return -1;
        }
        return 0;
    }

    public void createHuman() {
        ManNames manNameStudents[] = ManNames.values();
        WomanNames womanNameStudent[] = WomanNames.values();
        SecondNames secondNameStudents[] = SecondNames.values();
        int sex = (int) (Math.random() * 10);
        int randomManName = (int) (Math.random() * manNameStudents.length);
        int randomWomanName = (int) (Math.random() * womanNameStudent.length);
        int randomSecondName = (int) (Math.random() * secondNameStudents.length);
        int randomParentName = (int) (Math.random() * manNameStudents.length);
        if (sex < 5) {
            name = manNameStudents[randomManName].getName();
            secondName = secondNameStudents[randomSecondName].getSecondName();
            parentName = manNameStudents[randomParentName].getName() + "ович";
        } else {
            name = womanNameStudent[randomWomanName].getName();
            secondName = secondNameStudents[randomSecondName].getSecondName() + "а";
            parentName = manNameStudents[randomParentName].getName() + "овна";
        }
    }
}

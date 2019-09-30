package classes.student;

import classes.address.Address;
import classes.human.Human;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Student extends Human {
    private final int id;
    private Address address;
    private Calendar dateBirth;
    private String phone;
    private String department;
    private int course;
    private String group;

    public Student(String name, String secondName, String parentName, int id, Address address,
                   Calendar dateBirth, String phone, String department, int course, String group) {
        super(name, secondName, parentName);
        this.id = id;
        this.address = address;
        this.dateBirth = dateBirth;
        this.phone = phone;
        this.department = department;
        this.course = course;
        this.group = group;
    }

    public Student (String name, String secondName, String parentName,int id, Calendar dateBirth) {
        super(name,secondName,parentName);
        this.dateBirth = dateBirth;
        this.id = id;
        this.course = 1;
    }

    public Student(int id) {
        this.id = id;
        createHuman();
        address = new Address();
        createDateBirth();
        setCourseStudent();
        setDepartmentAndGroupStudent();
    }

    public Student(int id, int course, String group, String department) {
        this(id);
        this.course = course;
        this.group = group;
        this.department = department.toLowerCase();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getSecondName() {
        return super.getSecondName();
    }

    public void setSecondName(String secondName) {
        super.setSecondName(secondName);
    }

    public String getParentName() {
        return super.getParentName();
    }

    public void setParentName(String parentName) {
        super.setParentName(parentName);
    }

    public Calendar getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Calendar dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return super.toString()
                + dateBirth.get(Calendar.DATE) + "/" + (dateBirth.get(Calendar.MONTH) + 1) + "/"
                + dateBirth.get(Calendar.YEAR) + " "
                + address
                + ". Факультет: " + department + ", "
                + course + " курс,"
                + " группа: " + group;
    }

    private GregorianCalendar createDateBirth() {
        GregorianCalendar date = new GregorianCalendar();
        date.set(Calendar.YEAR, (int) (Math.random() * 5) + 1998);
        date.set(Calendar.MONTH, (int) (Math.random() * 12));
        date.set(Calendar.DAY_OF_MONTH, (int) (Math.random() * 28 + 1));
        return date;
    }

    private void setCourseStudent() {
        dateBirth = createDateBirth();
        int year = (dateBirth.get(Calendar.YEAR));
        switch (year) {
            case 1998:
                course = 5;
                break;
            case 1999:
                course = 4;
                break;
            case 2000:
                course = 3;
                break;
            case 2001:
                course = 2;
                break;
            case 2002:
                course = 1;
                break;
        }
    }

    private void setDepartmentAndGroupStudent() {
        Faculty[] faculties = Faculty.values();
        int depar = (int) (Math.random() * faculties.length);
        department = faculties[depar].getDepartment();
        Faculty departmentEnum = faculties[depar];
        int randomGroup = (int) ((Math.random() * 3) + 1);
        switch (departmentEnum) {
            case LAW:
                group = "" + course + randomGroup + "юр";
                break;
            case MATH:
                group = "" + course + randomGroup + "м";
                break;
            case BIOLOGY:
                group = "" + course + randomGroup + "б";
                break;
            case HISTORY:
                group = "" + course + randomGroup + "н";
                break;
            case PHYSICS:
                group = "" + course + randomGroup + "физ ";
                break;
            case ECONOMICS:
                group = "" + course + randomGroup + "эк";
                break;
            case PSYCHOLOGY:
                group = "" + course + randomGroup + "пс";
                break;
        }
    }
}

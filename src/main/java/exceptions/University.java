package exceptions;

import exceptions.ex.ListDepartmentEmpty;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String nameUniversity;
    List<Department> departments;

    public University() {
    }

    public University(String nameUniversity, List<Department> departments) {
        this.nameUniversity = nameUniversity;
        this.departments = departments;
    }

    public String getNameUniversity() {
        return nameUniversity;
    }

    public void setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(Department department ) {
        departments.add(department);
    }

    public void deleteDepartment(Department department) {
        departments.remove(department);
    }

    public List<Student> getAllStudentsUniversity() throws ListDepartmentEmpty {
        if (departments.isEmpty()) {
            throw new ListDepartmentEmpty();
        }
        List<Student> allStudents = new ArrayList<>();
        for (Department department : departments) {
            allStudents.addAll(department.getAllStudentDepartment());
        }
        return allStudents;
    }

    public List<Student> getStudentsFromDepartment(String nameDepartment) throws ListDepartmentEmpty {
        if (departments.isEmpty()) {
            throw new ListDepartmentEmpty();
        }
        List<Student> studentList = new ArrayList<>();
        for (Department department : departments) {
            if (department.getNameDepartment().equals(nameDepartment)) {
                studentList.addAll(department.getAllStudentDepartment());
            }
        }
        return studentList;
    }

    public List<Group> getGroupsFromDepartment(String nameDepartment) {
        List<Group> groupList = new ArrayList<>();
        for (Department department : departments) {
            if (department.getNameDepartment().equals(nameDepartment)) {
                groupList.addAll(department.getGroups());
            }
        }
        return groupList;
    }

    public List<Student> getStudentsFromDepartmentAndGroup(String department, String group) {
        List<Group> groups = getGroupsFromDepartment(department);
        List<Student> students = new ArrayList<>();
        for (Group group1 : groups) {
            if (group1.getNameGroup().equals(group)) {
                students.addAll(group1.getStudents());
            }
        }
        return students;
    }

    public List<Student> getStudentsFromDepartmentAdnGroupAndSubject(String department, String group, String subject) {
        List<Student> students = getStudentsFromDepartmentAndGroup(department, group);
        for (Student student : students) {
            if (!student.getInfo().containsKey(subject)) {
                students.remove(student);
            }
        }
        return students;
    }

    public double avgGardenSubjectForDepartmentAndGroup(String department, String group, String subject) {
        double sum = 0.0;
        List<Student> students = getStudentsFromDepartmentAdnGroupAndSubject(department, group, subject);
        for (Student student : students) {
            sum += student.getInfo().get(subject);
        }
        return sum / students.size();
    }

    public double avgAll(String subject) throws ListDepartmentEmpty {
        List<Student> students = getAllStudentsUniversity();
        double sum = 0.0;
        int count = 0;
        for (Student student : students) {
            if (student.getInfo().containsKey(subject)) {
                sum += student.getInfo().get(subject);
                count++;
            }
        }
        return sum / count;
    }
}

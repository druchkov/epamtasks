package exceptions;

import exceptions.ex.ListGroupsEmpty;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String nameDepartment;
    private List<Group> groups;

    public Department(String nameDepartment, List<Group> groups) {
        this.nameDepartment = nameDepartment;
        this.groups = groups;
    }

    public Department() {
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void addGruop(Group group) {
        groups.add(group);
    }

    public void deleteGroup(Group group) {
        groups.remove(group);
    }

    public List<Student> getAllStudentDepartment() throws ListGroupsEmpty {
        List<Student> allStudentsDepartment = new ArrayList<>();
        if (groups.isEmpty()) {
            throw new ListGroupsEmpty();
        }
        for (Group group : groups) {
            allStudentsDepartment.addAll(group.getStudents());
        }
        return allStudentsDepartment;
    }

    public List<Student> getStudentsFromGroup(String nameGroup) throws ListGroupsEmpty {
        if (groups.isEmpty()) {
            throw new ListGroupsEmpty();
        }
        List<Student> studentsFromGroup = new ArrayList<>();
        for (Group group : groups) {
            if (group.getNameGroup().equals(nameGroup)) {
                studentsFromGroup.addAll(group.getStudents());
            }
        }
        return studentsFromGroup;
    }

    public List<Student> findStudentsInGroupAndSubject(String group, String subject) throws ListGroupsEmpty {
        List<Student> studentList = getStudentsFromGroup(group);
        for (Student student : studentList) {
            if (!student.getInfo().containsKey(subject)) {
                studentList.remove(student);
            }
        }
        return studentList;
    }

    public double avgFromGroupAnsSubject(String group, String subject) throws ListGroupsEmpty {
        double sum = 0.0;
        int count = 0;
        for (Student student : findStudentsInGroupAndSubject(group, subject)) {
            sum += student.getInfo().get(subject);
            count++;
        }
        return sum / count;
    }
}

package exceptions;

import exceptions.ex.ListStudentInGroupEmpty;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String nameGroup;
    private List<Student> students;

    public Group(String nameGroup, List<Student> students) {
        this.nameGroup = nameGroup;
        this.students = students;
    }

    public Group() {
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addStudents(List<Student> students) {
        students.addAll(students);
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }

    public void deleteStudent(List<Student> students) {
        students.removeAll(students);
    }

    public List<Student> findStudentOnSubject(String nameSubject) throws ListStudentInGroupEmpty {
        if (students.isEmpty()) {
            throw new ListStudentInGroupEmpty();
        }
        List<Student> studentsList = new ArrayList<>();
        for (Student student : students) {
            if (student.getInfo().containsValue(nameSubject)) {
                studentsList.add(student);
            }
        }
        return studentsList;
    }
}

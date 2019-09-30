package classes.student;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainStudent {
    public static void main(String[] args) {
        // может я не понял задания и это нада было сделать отдельные методы для формирования необходимых списков
        Student[] students = new Student[100];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(i);
        }
        // список студентов задонного факулльтета
        System.out.println("Студенты факультета " + Faculty.PHYSICS.getDepartment() );
        for (int i = 0; i < students.length ; i++) {
            if (students[i].getDepartment().equals(Faculty.PHYSICS.getDepartment())) {
                System.out.println(students[i]);
            }
        }
        //списки студентов для каждого факультета и курса;
        for (int i = 0; i < students.length ; i++) {
            int studentCourse = students[i].getCourse();
            String faculty =  students[i].getDepartment();
            if(faculty.equals(Faculty.HISTORY.getDepartment()) && studentCourse == 3) {
                System.out.println(students[i]);
            }
        }
        // список студентов, родившихся после заданного года;
        Calendar date = new GregorianCalendar(1999, Calendar.AUGUST, 25);
        for (int i = 0; i < students.length; i++) {
            if (students[i].getDateBirth().compareTo(date) > 0) {
                System.out.println(students[i]);
            }
        }
        // список группы
        for (int i = 0; i < students.length ; i++) {
            if (students[i].getGroup().equals("32н")) {
                System.out.println(students[i]);
            }
        }
    }
}

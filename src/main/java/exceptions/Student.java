package exceptions;

import classes.human.Human;
import exceptions.ex.IllegalArgumentGardenException;
import exceptions.ex.SetSubjectEmpty;

import java.util.List;
import java.util.Map;

public class Student extends Human {
    private List<String> subject;
    private List<Integer> gardens;
    private Map<String, Integer> info;

    public Student(String name, String secondName, String parentName, List<String> subject, List<Integer> gardens) {
        super(name, secondName, parentName);
        this.subject = subject;
        this.gardens = gardens;
    }

    public Student(String name, String secondName, String parentName, Map<String, Integer> info) {
        super(name, secondName, parentName);
        this.info = info;
    }

    public Map<String, Integer> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Integer> info) {
        this.info = info;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    public List<Integer> getGardens() {
        return gardens;
    }

    public void setGardens(List<Integer> gardens) {
        this.gardens = gardens;
    }

    public Student createInfoStudent(List<String> subject, List<Integer> gardens)
            throws IllegalArgumentGardenException, SetSubjectEmpty {
        if (subject.isEmpty()) {
            throw new SetSubjectEmpty();
        }
        if (subject.size() == gardens.size()) {
            for (int i = 0; i < subject.size(); i++) {
                if (gardens.get(i) < 0 || gardens.get(i) > 10) {
                    throw new IllegalArgumentGardenException();
                }
                info.put(subject.get(i), gardens.get(i));
            }
        }
        return this;
    }

    public double avg() throws SetSubjectEmpty, IllegalArgumentGardenException {
        double sum = 0;
        if (info.isEmpty()) {
            createInfoStudent(subject, gardens);
        }
        for (Map.Entry<String, Integer> student : info.entrySet()) {
            sum += student.getValue();
        }
        return sum / info.size();
    }

    public void addSubjectWithGarden(String subject, int garden) {
        if(garden > 10 || garden < 0) {
            throw new IllegalArgumentException();
        }
        info.put(subject, garden);
    }

    public void deleteSubjectWithGarden(String subject) {
        info.remove(subject);
    }
}

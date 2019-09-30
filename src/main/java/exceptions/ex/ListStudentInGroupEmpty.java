package exceptions.ex;

public class ListStudentInGroupEmpty extends Exception {
    public ListStudentInGroupEmpty() {
    }

    public ListStudentInGroupEmpty(String message) {
        super(message);
    }

    public ListStudentInGroupEmpty(String message, Throwable cause) {
        super(message, cause);
    }

    public ListStudentInGroupEmpty(Throwable cause) {
        super(cause);
    }
}

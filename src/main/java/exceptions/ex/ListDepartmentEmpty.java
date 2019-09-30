package exceptions.ex;

public class ListDepartmentEmpty extends Exception {
    public ListDepartmentEmpty() {
    }

    public ListDepartmentEmpty(String message) {
        super(message);
    }

    public ListDepartmentEmpty(String message, Throwable cause) {
        super(message, cause);
    }

    public ListDepartmentEmpty(Throwable cause) {
        super(cause);
    }
}

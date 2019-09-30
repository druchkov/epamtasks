package exceptions.ex;

public class SetSubjectEmpty extends Exception {
    public SetSubjectEmpty() {
    }

    public SetSubjectEmpty(String message) {
        super(message);
    }

    public SetSubjectEmpty(String message, Throwable cause) {
        super(message, cause);
    }

    public SetSubjectEmpty(Throwable cause) {
        super(cause);
    }
}

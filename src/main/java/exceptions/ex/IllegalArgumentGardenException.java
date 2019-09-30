package exceptions.ex;

public class IllegalArgumentGardenException extends Exception {
    public IllegalArgumentGardenException() {
    }

    public IllegalArgumentGardenException(String message) {
        super(message);
    }

    public IllegalArgumentGardenException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalArgumentGardenException(Throwable cause) {
        super(cause);
    }
}

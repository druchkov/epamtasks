package exceptions.ex;

public class ListGroupsEmpty extends ListDepartmentEmpty{
    public ListGroupsEmpty() {
    }

    public ListGroupsEmpty(String message) {
        super(message);
    }

    public ListGroupsEmpty(String message, Throwable cause) {
        super(message, cause);
    }

    public ListGroupsEmpty(Throwable cause) {
        super(cause);
    }
}

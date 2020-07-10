package javaExceptions.exceptions;

public class GroupHasNoStudentsException extends Exception {

    public GroupHasNoStudentsException() {
        System.out.println("Group shouldn't be empty!");
    }

    public GroupHasNoStudentsException(String message) {
        super(message);
    }

    public GroupHasNoStudentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public GroupHasNoStudentsException(Throwable cause) {
        super(cause);
    }
}

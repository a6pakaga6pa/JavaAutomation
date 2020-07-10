package javaExceptions.exceptions;

public class FacultyHasNoGroupException extends Throwable {
    public FacultyHasNoGroupException() {
        System.out.println("Faculty should have at least 1 group!");
    }

    public FacultyHasNoGroupException(String message) {
        super(message);
    }

    public FacultyHasNoGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacultyHasNoGroupException(Throwable cause) {
        super(cause);
    }
}

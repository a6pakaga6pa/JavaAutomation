package javaExceptions.exceptions;

public class MarkOutOfBoundsException extends Exception {
    public MarkOutOfBoundsException() {
        System.out.println("Marks should be from 0 to 10!");
    }

    public MarkOutOfBoundsException(String message) {
        super(message);
    }

    public MarkOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarkOutOfBoundsException(Throwable cause) {
        super(cause);
    }
}

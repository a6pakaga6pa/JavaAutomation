package javaExceptions.exceptions;

public class StudentHasNoSubjectException extends Exception {
    public StudentHasNoSubjectException() {
        System.out.println("Student has to have at least 1 subject to visit!");
    }

    public StudentHasNoSubjectException(String message) {
        super(message);
    }

    public StudentHasNoSubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentHasNoSubjectException(Throwable cause) {
        super(cause);
    }
}

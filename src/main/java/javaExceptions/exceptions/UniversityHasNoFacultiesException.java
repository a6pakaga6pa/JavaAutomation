package javaExceptions.exceptions;

public class UniversityHasNoFacultiesException extends Throwable {
    public UniversityHasNoFacultiesException(String s) {
    }

    public UniversityHasNoFacultiesException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniversityHasNoFacultiesException(Throwable cause) {
        super(cause);
    }

    public UniversityHasNoFacultiesException() {
    }
}

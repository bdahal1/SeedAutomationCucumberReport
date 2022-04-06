package exceptions;

public abstract class ProjectException extends Exception {

    public ProjectException() {
        super();
    }

    public ProjectException(String message) {
        super(message);
    }
}

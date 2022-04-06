package exceptions;

public class IntermittentErrorException extends ProjectException {

    public IntermittentErrorException() {
        super();
    }

    public IntermittentErrorException(String message) {
        super(message);
    }
}

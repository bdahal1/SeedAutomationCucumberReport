package exceptions;

public class APIUnknownErrorException extends ProjectException {

    private Exception originalException;

    public APIUnknownErrorException() {
        super();
    }

    public APIUnknownErrorException(String message) { super(message); }

    public APIUnknownErrorException(String message, Exception originalException) {
        super(message);
        this.originalException = originalException; }
}

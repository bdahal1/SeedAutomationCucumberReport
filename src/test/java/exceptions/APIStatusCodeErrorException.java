package exceptions;

public class APIStatusCodeErrorException extends ProjectException {

    public APIStatusCodeErrorException() {
        super();
    }

    public APIStatusCodeErrorException(String message, Integer statusCode) {

        super(message + ":" + Integer.toString(statusCode));
    }
}

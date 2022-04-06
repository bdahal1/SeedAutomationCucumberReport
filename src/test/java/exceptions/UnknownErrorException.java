package exceptions;


import com.configuration.Log;

public class UnknownErrorException extends ProjectException {

    private Exception originatingException;

    public UnknownErrorException() {
        super();
    }

    public UnknownErrorException(String message) {
        super(message);
    }

    public UnknownErrorException(String message, Exception originatingException) {
        super(message);
        this.originatingException = originatingException;
        Log.logException(originatingException);
    }
}

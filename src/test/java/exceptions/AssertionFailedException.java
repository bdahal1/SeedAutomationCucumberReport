package exceptions;

import com.configuration.Log;

public class AssertionFailedException extends ProjectException {

    private Exception originatingException;

    public AssertionFailedException() {
        super();
    }

    public AssertionFailedException(String message) {
        super(message);
    }

    public AssertionFailedException(String message, Exception originatingException) {
        super(message);
        this.originatingException = originatingException;
    }

}

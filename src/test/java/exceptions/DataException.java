package exceptions;

/**
 * Exception thrown when data state is invalid
 */
public class DataException extends ProjectException {

    public DataException() {
        super();
    }

    public DataException(String message) {
        super(message);
    }

}

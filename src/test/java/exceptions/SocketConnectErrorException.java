package exceptions;

public class SocketConnectErrorException extends ProjectException {

    public SocketConnectErrorException() {
        super();
    }

    public SocketConnectErrorException(String message) {
        super(message);
    }
}

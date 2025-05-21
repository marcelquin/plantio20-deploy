package App.Infra.Exceptions;

public class IllegalActionException extends RuntimeException {

    public IllegalActionException() {
        super("Ops, algo deu errado.");
    }

    public IllegalActionException(String message) {
        super(message);
    }

}

package exception;

public class duplicidadeDeEmailException extends RuntimeException {
    private final String message;

    public duplicidadeDeEmailException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

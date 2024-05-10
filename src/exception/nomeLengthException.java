package exception;

public class nomeLengthException extends RuntimeException {
    private final String message;

    public nomeLengthException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

package exception;

public class answerNotRemoveException extends RuntimeException {
    private final String message;

    public answerNotRemoveException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

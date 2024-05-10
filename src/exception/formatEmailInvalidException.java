package exception;

public class formatEmailInvalidException extends RuntimeException {
    private final String message;

    public formatEmailInvalidException(String formatoDoEmailInvalido) {
        this.message = formatoDoEmailInvalido;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

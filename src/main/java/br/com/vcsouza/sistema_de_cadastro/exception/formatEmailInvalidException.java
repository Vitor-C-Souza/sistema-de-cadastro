package br.com.vcsouza.sistema_de_cadastro.exception;

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

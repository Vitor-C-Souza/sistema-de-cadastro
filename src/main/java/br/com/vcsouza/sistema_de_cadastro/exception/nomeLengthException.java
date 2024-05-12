package br.com.vcsouza.sistema_de_cadastro.exception;

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

package br.com.vcsouza.sistema_de_cadastro.exception;

public class idadeInvalidException extends RuntimeException {
    private final String message;

    public idadeInvalidException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
